
import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args){
    String layout = "templates/layout.vtl";

    get("/", (req,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/tamaMade", (req, res) -> {

      String tamaName = req.queryParams("tamaName");
      Tamagotchi yourTama = new Tamagotchi(tamaName);

      // // potentially for multiple Tamagotchi:
      // req.session().attribute(yourTama.getName(), yourTama);
      req.session().attribute("tama", yourTama);

      System.out.println(req.session().attributes());


      Map<String, Object> model = new HashMap<String, Object>();

      model.put("tama", req.session().attribute("tama"));

      model.put("tamaName", yourTama.getName());
      model.put("tamaStatus", yourTama.checkStatus());
      model.put("template", "templates/tamaPlayground.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    //on click reroute, increment time.
  }

}
