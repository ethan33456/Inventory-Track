package com.LiftOff.InventoryTrack.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Storefront {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    private ArrayList<Product> products = new ArrayList<>();

    public Storefront(String name, String description, ArrayList<Product> products) {
        this();
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public Storefront() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {return name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storefront that = (Storefront) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
