package com.LiftOff.InventoryTrack.models;

import com.sun.istack.NotNull;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User extends AbstractEntity {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;



    public User() {}



    public User(String username, String password) {
        this.username = username;
        this.pwHash = password;
    }



    public String getUsername() {
        return username;
    }

}