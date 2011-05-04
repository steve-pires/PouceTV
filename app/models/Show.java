package models;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Show extends Model {
	@Required
	public String name;
	
	@ManyToOne
	@Required
	public Channel channel;

	public Show() {
		super();
	}

	@Override
	public String toString() {
		return name + " (" + id + ")";
	}

}
