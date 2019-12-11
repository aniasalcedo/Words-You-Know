package org.launchcode.WordsYouKnow.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User {

    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min= 3, max=20, message = "Login must be between 3-20 characters")
    private String username;

    @NotNull
    @Size(min=5, message = "Password must be at least 5 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public User () {

    }

    public int getId() {
        return id;
    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    // I don't know yet if and why I need this

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }
    private void checkPassword(){
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}

