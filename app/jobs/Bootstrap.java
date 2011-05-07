package jobs;

import models.User;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() {
        Fixtures.deleteAllModels();
        Fixtures.loadModels("../test/users.yml");
        Fixtures.loadModels("../test/data.yml");
        Logger.info("RESET DB");
	}
}
