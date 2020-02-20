
package org.launchcode.WordsYouKnow.Controllers;

import org.launchcode.WordsYouKnow.Models.Data.UserDao;
import org.launchcode.WordsYouKnow.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User newUser, BindingResult result) {

        model.addAttribute(newUser);

        if (result.hasErrors()) {
            return "register";
        }

        userDao.save(newUser);
        model.addAttribute("users", userDao.findAll());
        return "redirect:/login";
    }


/////////////////////////////////////////////////////
//        login
////////////////////////////////////////////////////

    @RequestMapping("/login")
    public String getloginform(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "login";
        }
        return "search";
    }


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestParam("username") String aUsername,
//                        @RequestParam("password") String aPassword,
//                        Model model)
//    {
//        User myFoundUser = userDao.findByUsername(aUsername);
//        if (myFoundUser !=null && aPassword.equals(myFoundUser.getPassword())) {
//            return "redirect:/search";
//        }
//        model.addAttribute("error", "invalid username or password");
//                return "login";
//    }

    /////////////////////////////////////////////////////
//        login again when you logout
////////////////////////////////////////////////////

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String loginfromlogout(@ModelAttribute(name = "User") User user, Model model, Errors errors) {
        String username = user.getUsername();
        String password = user.getPassword();

        User myFoundUser = userDao.findByUsername(username);
        if (myFoundUser != null && password.equals(myFoundUser.getPassword())) {
            return "redirect:/search";
        }
        if (errors.hasErrors()) {
            return "login";
        }
        model.addAttribute("invalidCredentials", true);
        return "logout";

        }

}