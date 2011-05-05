package controllers;

import java.util.Date;
import java.util.List;

import models.Channel;
import models.Vote;
import play.mvc.Controller;
import play.test.Fixtures;

public class Application extends Controller {

    public static void index() {
	List<Channel> channels = Channel.all().fetch();
	render(channels);
    }

    public static void show(String fId){
	Channel channel = Channel.find("byFId", fId).first();
	render(channel);
    }
    
    public static void vote(int value, Long idChannel) {
	System.out.println("bhb");
	Date date = new Date();
	Vote vote = new Vote(value, "cdcd", date.getTime(), (Channel) Channel.findById(idChannel));
	vote.save();
    }

}