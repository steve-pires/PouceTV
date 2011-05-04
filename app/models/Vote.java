package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Vote extends Model {
    @Required
    public int valeur;
    @Required
    public String ipVote;
    @Required
    public long timestamp;
    @Required
    @ManyToOne(cascade = { CascadeType.ALL })
    public Channel channel;

    public Vote() {
	super();
    }

    public Vote(int valeur, String ipVote, long timestamp, Channel channel) {
	super();
	this.valeur = valeur;
	this.ipVote = ipVote;
	this.timestamp = timestamp;
	this.channel = channel;
    }

}
