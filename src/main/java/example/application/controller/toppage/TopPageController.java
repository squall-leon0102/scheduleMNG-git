package example.application.controller.toppage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopPageController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String createTopPage() {
        System.out.println("createTop");
        return "top/main-menu";
    }

}
