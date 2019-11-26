package org.launchcode.WordsYouKnow.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WordBank {
    @Id
    @GeneratedValue
    private int id;
}
