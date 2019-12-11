package org.launchcode.WordsYouKnow.Models;

import org.aspectj.weaver.loadtime.definition.Definition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word {
    @Id
    @GeneratedValue
    private int id;
}
//    private static int nextId = 1;
//
//    private Word word;
//    private Definition definition;
//
//    public Word(Word aWord, Definition aDefinition) {
//        this();
//
//        word = aWord;
//        definition = aDefinition;
//    }
//
//    public Word getWord() {
//        return word;
//    }
//
//    public void setWord(Word word) {
//        this.word = word;
//    }
//
//    public Definition getDefinition() {
//        return definition;
//    }
//
//    public void setDefinition(Definition definition) {
//        this.definition = definition;
//    }
//}