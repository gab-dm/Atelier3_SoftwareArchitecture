package com.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public final class User {



    @Id
    @GeneratedValue


    private Integer id;
    private String name;
    private String pswd;
    private float solde=500;

   public User() {};


    public User ( String _name , String _pswd ) {

        super();
        this.name = _name;
        this.pswd = _pswd;

        this.solde = 500;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    @Override
    public String toString() {
        return "id :"+ this.id+ "name: "+this.name + " Mot de passe: " + this.pswd + " Solde : " + this.solde ;
    }


    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }






}

