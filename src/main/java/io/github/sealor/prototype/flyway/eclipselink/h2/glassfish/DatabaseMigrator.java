package io.github.sealor.prototype.flyway.eclipselink.h2.glassfish;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;

@Singleton
@Startup
public class DatabaseMigrator {

	@Resource(lookup = "jdbc/h2database")
	private DataSource dataSource;

	@PostConstruct
	private void onStartup() {
		if (this.dataSource == null) {
			logErr("DataSource 'h2database' not found for flyway migration!");
			return;
		}

		Flyway flyway = new Flyway();
		flyway.setInitOnMigrate(true);
		flyway.setDataSource(this.dataSource);

		for (MigrationInfo migrationInfo : flyway.info().all()) {
			String version = migrationInfo.getVersion().getVersion();
			String state = migrationInfo.getState().getDisplayName();
			String name = migrationInfo.getScript();

			logInfo(String.format("%s %s - %s", version, state, name));
		}

		flyway.migrate();
	}

	private void logErr(String text) {
		System.err.println(text);
	}

	private void logInfo(String text) {
		System.out.println(text);
	}
}
