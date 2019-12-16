package org.launchcode.WordsYouKnow.Models;

import com.sun.istack.NotNull;
import org.aspectj.weaver.loadtime.definition.Definition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class NewWord {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(message = "Please enter a word.")
    private String word;


    @NotNull
    @Size(message = "Please enter its definition.")
    private String definition;

    public NewWord(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }


    public NewWord() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
