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
    private UserDao UserDao;

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors) { //add this if needed , String verifypassword

        model.addAttribute(user);
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

    UserDao.save(user);
//            User myvaliduser = new User(user.getUsername(), user.getPassword());
//            UserDao.save(myvaliduser);
            return "myprofile";
        }
    }
