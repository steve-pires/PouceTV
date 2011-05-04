package controllers;

import java.util.List;

import models.Channel;
import play.mvc.With;

@With(Secure.class)
@Check("ADMIN")
public class Channels extends CRUD {
}