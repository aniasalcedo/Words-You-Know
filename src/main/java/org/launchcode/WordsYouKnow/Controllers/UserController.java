
package org.launchcode.WordsYouKnow.Controllers;

import org.launchcode.WordsYouKnow.Models.Data.UserDao;
import org.launchcode.WordsYouKnow.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(value="")
public class UserController {

    @Autowired
    private UserDao userDao;

    /////////////////////////////////////////////////////
// registration
/////////////////////////////////////////////////////

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User newUser,
                      Errors errors) { //add this if needed , String verifypassword

        model.addAttribute(newUser);
//        boolean passwordsMatch = true;
//        if (user.getPassword() == null || verifypassword == null
//                || !user.getPassword().equals(verifypassword)) {
//            passwordsMatch = false;
//            user.setPassword("");
//            model.addAttribute("verifypassword", "Passwords must match");
//        }

        if (errors.hasErrors()) {
            return "register";
        }

        userDao.save(newUser);
//            User myvaliduser = new User(user.getUsername(), user.getPassword());
//            UserDao.save(myvaliduser);
        return "redirect:/login";
    }


/////////////////////////////////////////////////////
//        login
////////////////////////////////////////////////////

//    @RequestMapping(value = "login")
//    public String login(Model model) {
//        model.addAttribute("users", userDao.findAll());
//        return "login";
//    }
//
//    @RequestMapping(value = "myprofile")
//    public String profile(Model model) {
//        model.addAttribute("users", userDao.findAll());
//        return "myprofile";
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String getloginform() {
//        model.addAttribute(new User());
//        model.addAttribute("title", "Login page");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "User") User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        User myFoundUser = userDao.findByUsername(username);
        if ( myFoundUser != null && password.equals(myFoundUser.getPassword())){
            return "myprofile";
        }
        model.addAttribute("invalidCredentials", true);
        return "login";

    }
}
