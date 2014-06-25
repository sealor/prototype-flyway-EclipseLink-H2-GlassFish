package io.github.sealor.prototype.flyway.eclipselink.h2.glassfish;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.glassfish.embeddable.CommandResult;
import org.glassfish.embeddable.CommandResult.ExitStatus;
import org.glassfish.embeddable.CommandRunner;
import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.junit.Test;

public class FlywayIT {

	@Test
	public void testFlywayMigration() throws GlassFishException, IOException {
		GlassFishProperties glassFishProperties = new GlassFishProperties();
		glassFishProperties.setPort("http-listener", 30080);

		GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassFishProperties);
		glassfish.start();

		CommandRunner commandRunner = glassfish.getCommandRunner();
		Deployer deployer = glassfish.getDeployer();

		CommandResult cmdResult = commandRunner.run("add-resources", "src/test/resources/glassfish-resources.xml");
		assertEquals(ExitStatus.SUCCESS, cmdResult.getExitStatus());

		File file = new File("target/prototype-flyway-EclipseLink-H2-GlassFish-1.0-SNAPSHOT.war");
		String deployResult = deployer.deploy(file, new String[] { "--contextroot=prototype" });
		assertEquals("prototype-flyway-EclipseLink-H2-GlassFish-1.0-SNAPSHOT", deployResult);

		glassfish.stop();
	}
}
