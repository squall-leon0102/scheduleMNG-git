//package example.application.controller.auth;
//
//import java.io.Serializable;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import example.application.form.auth.AuthLoginForm;
//import example.application.form.auth.AuthSessionForm;
//import example.application.helper.AuthHelper;
//
///**
// * @author n.u
// *
// */
//@Controller
////scopedTarget.Bean名でセッション管理できる
//@SessionAttributes("scopedTarget.authSessionForm")
//public class AuthController implements Serializable{
//
//    @Autowired
//    AuthHelper authHelper;
//
////    @Autowired
////    UserMapper userMapper;
//
//    @Autowired
//    AuthSessionForm authSessionForm;
//
//    @ModelAttribute
//    AuthLoginForm setAuthLoginForm() {
//        return new AuthLoginForm();
//    }
//
//    @RequestMapping(path="/", method = RequestMethod.GET)
//    public String createLoginView(AuthLoginForm authLoginForm, Model model) {
//
//        model.addAttribute("authLoginForm", authLoginForm);
//
//        return "auth/login";
//
//    }
//
//
//
//
//}
