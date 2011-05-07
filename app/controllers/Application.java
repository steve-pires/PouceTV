package controllers;

import java.util.Date;
import java.util.List;

import models.Channel;
import models.Show;
import models.Vote;
import play.Logger;
import play.mvc.Controller;
import play.test.Fixtures;

public class Application extends Controller {

	public static void index() {
		List<Channel> channels = Channel.all().fetch();
		render(channels);
	}

	public static void show(String fId) {
		Channel channel = Channel.find("byFId", fId).first();
		Show show = Show.find("byChannel", channel).first();

		render(channel, show);
	}

	public static void postVote(Long idChannel) {
		Date date = new Date();
		Channel channel = (Channel) Channel.findById(idChannel);
		Boolean up = null;

		if (params.get("up") != null) {
			up = true;
		} else if (params.get("down") != null) {
			up = false;
		}

		if (channel != null && up != null) {
			Vote vote = new Vote(up ? 1 : -1, "cdcd", date.getTime(), channel);
			vote.save();
			Logger.info("vote saved (" + (up ? "+1" : "-1") + " for " + channel.name + ")");

			show(channel.fId);
		} else {
			index();
		}
	}

}