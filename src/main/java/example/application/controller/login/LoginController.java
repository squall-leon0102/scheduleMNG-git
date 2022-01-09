package example.application.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author n.u
 *
 */
@Controller
public class LoginController {

    @RequestMapping(path="/login", method = RequestMethod.GET)
    public String createLoginView(Model model) {


        return "auth/login";

    }

    /**
     * メインページに遷移する。
     * ログインが成功した場合、このメソッドが呼び出される。
     */
    @RequestMapping("/")
    public String login(Model model) {

        //メインページ。
        return "top/main-menu";
    }


}
