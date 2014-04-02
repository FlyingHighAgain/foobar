package controllers;

import models.Bar;
import play.*;
import play.data.Form;
import play.mvc.*;
import java.util.List;
import play.db.ebean.Model;
import static play.libs.Json.toJson;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addBar() {
    	Bar bar = Form.form(Bar.class).bindFromRequest().get();
    	bar.save();
    	return redirect(routes.Application.index());
    }

    public static Result getBars() {
    	List<Bar> bars = new Model.Finder(String.class, Bar.class).all();
    	return ok(toJson(bars));
    }
}
