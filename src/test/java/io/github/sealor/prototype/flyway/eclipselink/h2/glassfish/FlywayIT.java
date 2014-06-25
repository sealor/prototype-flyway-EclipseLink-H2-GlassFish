package io.github.sealor.prototype.flyway.eclipselink.h2.glassfish;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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

		URL url = new URL("http://localhost:30080/prototype/books");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		InputStream stream = connection.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		while (stream.available() > 0) {
			int len = stream.read(buffer);
			baos.write(buffer, 0, len);
		}
		stream.close();
		assertEquals("", baos.toString());

		glassfish.stop();
	}
}
