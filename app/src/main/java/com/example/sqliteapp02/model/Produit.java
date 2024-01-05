package com.example.sqliteapp02.model;

public class Produit {
    private String name;
    private String prix;

    private Integer id;

    public Produit(String name, String prix,Integer id) {
        this.name = name;
        this.prix = prix;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPrix() {
        return prix;
    }

    public Integer getId() {
        return id;
    }
}
