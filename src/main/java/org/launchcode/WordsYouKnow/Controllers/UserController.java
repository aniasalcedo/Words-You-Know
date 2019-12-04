package org.launchcode.WordsYouKnow.Controllers;

import org.launchcode.WordsYouKnow.Models.Data.UserDao;
import org.launchcode.WordsYouKnow.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController {
    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    @RequestMapping("/login")
    @ResponseBody
    public String create(String name, String password) {
        User user = null;
        try {
            user = new User(name, password);
            UserDao.save(user);
        }
        catch (Exception exception) {
            return "Error creating the user";
        }
        return "User succesfully created!";
    }
    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private UserDao UserDao;
}
