package controllers;

import java.util.Date;
import java.util.List;

import models.Channel;
import models.Vote;
import play.mvc.Controller;
import play.test.Fixtures;

public class Application extends Controller {

    public static void reset() {
	Fixtures.deleteDatabase();
	Fixtures.loadModels("../test/users.yml");
	Fixtures.loadModels("../test/data.yml");

	CRUD.index();
    }

    public static void index() {
	List<Channel> channels = Channel.find("order by id desc").from(0).fetch(10);
	render(channels);
    }

    public static void vote(int value, Double channel) {
	System.out.println("bhb");
	Date date = new Date();
	Vote vote = new Vote(value, "cdcd", date.getTime(), (Channel) Channel.findById(channel));
	vote.save();
    }

}