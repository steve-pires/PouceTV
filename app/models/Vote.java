package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

import java.text.SimpleDateFormat;

@Entity
public class Vote extends Model {
	@Required
	public int value;
	@Required
	public String ipVote;
	@Required
	public long timestamp;
	@Required
	@ManyToOne(cascade = {CascadeType.ALL})
	public Channel channel;

	public Vote() {
		super();
	}

	public Vote(int value, String ipVote, long timestamp, Channel channel) {
		super();
		this.value = value;
		this.ipVote = ipVote;
		this.timestamp = timestamp;
		this.channel = channel;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh:mm:ss");
		return "Vote " + this.value + " pour " + channel.name +" à " + sdf.format(this.timestamp);
	}
}
