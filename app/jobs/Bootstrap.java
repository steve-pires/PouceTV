package jobs;

import models.User;
import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() {
		if (User.count() == 0) {
			Fixtures.loadModels("../test/users.yml");
			Logger.info("La table User était vide");
		}
	}
}
