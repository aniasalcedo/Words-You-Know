package org.launchcode.WordsYouKnow.Controllers;

import org.graalvm.compiler.word.Word;
import org.launchcode.WordsYouKnow.Models.Data.NewWordDao;
import org.launchcode.WordsYouKnow.Models.NewWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="")
public class NewWordController {

    @Autowired
    private NewWordDao newWordDao;

    @RequestMapping(value = "add")
    public String index(Model model) {
        model.addAttribute("title", "Add a new Word");
        model.addAttribute("word", newWordDao.findAll());
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayadd(Model model) {
        model.addAttribute(new NewWord());
//        model.addAttribute("title", "Add a new word");
        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processadd(Model model, @ModelAttribute @Valid NewWord newWord, Errors errors) {


        if (errors.hasErrors()) {
            return "add";
        }

        newWordDao.save(newWord);
        return "add";
    }

    //////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////// SEARCH THROUGH THE NEW WORD DATABASE/////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String displaywords(Model model) {

        model.addAttribute("newWords", newWordDao.findAll());

        return "search";
    }


/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////EDIT WORD//////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value="edit/{id}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int id) {
    model.addAttribute("word", newWordDao.findById(id));

    return "edit";
    }


    @RequestMapping(value="edit/{id}", method = RequestMethod.POST)
    public String processEditForm(@PathVariable int id, BindingResult result, @ModelAttribute @Valid NewWord newWord, Errors errors, @RequestParam int newWordId, Model model){

        if(result.hasErrors()) {
            model.addAttribute("title", "Edit Word");
            newWord.setId(id);
            return "edit";
        }
        newWordDao.save(newWord);
        model.addAttribute("newWords", newWordDao.findAll());
        return "search";
//    NewWord theNewWord = newWordDao.findById(newWord.id);
//    theNewWord.setWord(newWord.getWord());
//    theNewWord.setDefinition(newWord.getDefinition());
//    newWordDao.save(theNewWord);
//    return "redirect:/search";
    }

/////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////DELETE WORD//////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
@GetMapping("/delete/{id}")
public String deleteNewWord(@PathVariable("id") long id, Model model) {
    NewWord newWord = newWordDao.findById((int) id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    newWordDao.delete(newWord);
    model.addAttribute("users", newWordDao.findAll());
     return "redirect:/search";
}
}
