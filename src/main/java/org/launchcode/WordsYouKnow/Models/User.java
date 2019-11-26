package org.launchcode.WordsYouKnow.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    public User(int id) {
        this.id = id;
    }
}
