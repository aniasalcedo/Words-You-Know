package org.launchcode.WordsYouKnow.Controllers;

import org.graalvm.compiler.word.Word;
import org.launchcode.WordsYouKnow.Models.Data.NewWordDao;
import org.launchcode.WordsYouKnow.Models.NewWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="")
public class NewWordController {

   @Autowired
   private NewWordDao newWordDao;

    @RequestMapping(value="add")
    public String index(Model model) {
        model.addAttribute("title", "Add a new Word");
        model.addAttribute("word", newWordDao.findAll());
        return "add";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayadd(Model model) {
        model.addAttribute(new NewWord());
        model.addAttribute("title", "Add a new word");
        return "add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processadd(Model model, @ModelAttribute @Valid NewWord newWord, Errors errors) {


        if (errors.hasErrors()) {
            return "add";
        }

        newWordDao.save(newWord);
        return "redirect:/add";

    }

}



