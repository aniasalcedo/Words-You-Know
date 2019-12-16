package org.launchcode.WordsYouKnow.Controllers;

import org.launchcode.WordsYouKnow.Models.Data.NewWordDao;
import org.launchcode.WordsYouKnow.Models.Data.WordBankDao;
import org.launchcode.WordsYouKnow.Models.Data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WordsYouKnowController {
    @Autowired
    private UserDao UserDao;

    @Autowired
    private NewWordDao newWordDao;

    @Autowired
    private WordBankDao WordBankDao;

    @RequestMapping(value = "")
    public String main(Model model) {
        return "login";
    }

//    @RequestMapping(value = "login")
//    public String login(Model model) {
//        return "login";
//    }

    @RequestMapping(value = "register")
    public String register(Model model) {
        return "register";
    }

//    @RequestMapping(value = "add")
//    public String add(Model model) {
//        return "add";
//    }

//    @RequestMapping(value = "search")
//    public String search(Model model) {
//        return "search";
//    }

    @RequestMapping(value = "logout")
    public String logout(Model model) {
        return "login";
    }

    @RequestMapping(value = "myprofile")
    public String myprofile(Model model) {
        return "myprofile";
    }
}