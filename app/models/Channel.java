package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Channel extends Model {
	@Required
	@Column(unique = true)
	public String name;

	@OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
	public List<Show> shows;

	public String iconUrl;

	public Channel() {
	}

	@Override
	public String toString() {
		return name + " (" + id + ")";
	}
}
