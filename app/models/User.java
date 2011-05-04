package models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class User extends Model {
	@Required
	@Email
	@Column(unique = true)
	public String email;

	@Required
	@Password
	public String password;

	@Required
	public String fullname;

	public boolean isAdmin;

	@Override
	public String toString() {
		return fullname + " (" + email + ")";
	}

	public static User connect(String email, String password) {
		return find("byEmailAndPassword", email, password).first();
	}
}
