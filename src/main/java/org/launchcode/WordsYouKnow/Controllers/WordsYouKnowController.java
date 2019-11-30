package org.launchcode.WordsYouKnow.Controllers;

import org.launchcode.WordsYouKnow.Models.Data.WordDao;
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
    private WordDao WordDao;

    @Autowired
    private WordBankDao WordBankDao;

    @RequestMapping(value = "")

    public String index(Model model) {
        return "fragments";
    }
}