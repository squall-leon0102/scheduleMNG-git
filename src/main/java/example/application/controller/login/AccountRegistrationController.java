package example.application.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.domain.entity.AccountRegisterEntity;
import example.domain.service.imp.AccountRegistrationService;

@Controller
public class AccountRegistrationController {

    @Autowired
    AccountRegistrationService accountRegistrationService;

    /**
    *
    * ログイン画面フォーム作成
    * @return
    */
    @ModelAttribute
    AccountRegisterEntity setUpForm() {
        return new AccountRegisterEntity();
    }

    /**
     * 会員情報入力画面に遷移する。
     */
    @RequestMapping(path = "/RegistrationForm", method = RequestMethod.GET)
    public String showRegistMemberForm(AccountRegisterEntity form, Model model) {

        model.addAttribute("AccountRegisterEntity", form);

        //会員情報入力画面。
        return "auth/RegistrationForm";
    }

    @RequestMapping(path = "/Register")
    public String registerUser(@ModelAttribute AccountRegisterEntity accountRegisterEntity) {

        //USERテーブルにinsertする時の引数。
        AccountRegisterEntity entity = new AccountRegisterEntity();

        entity.setName(accountRegisterEntity.getName());
        entity.setPassword(accountRegisterEntity.getPassword());

        //USERテーブルにinsertする。
        accountRegistrationService.registerAccount(entity);

        return "auth/Result";
    }
}