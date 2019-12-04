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
@RequestMapping("user")
public class UserController {
    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title","Register");
        return "myprofile";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors, String verify) {
        model.addAttribute(user);
        boolean passwordsMatch = true;
        if (user.getPassword() == null || verify == null
                || !user.getPassword().equals(verify)) {
            passwordsMatch = false;
            user.setPassword("");
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            return "user/index";
        }

        return "user/add";
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String create(String name, String password) {
//        User user = null;
//        try {
//            user = new User(name, password);
//            UserDao.save(user);
//        }
//        catch (Exception exception) {
//            return "Error creating the user";
//        }
//        return "User succesfully created!";
//    }
    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private UserDao UserDao;
}
