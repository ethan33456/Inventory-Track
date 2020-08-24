package com.LiftOff.InventoryTrack.models;


import java.util.ArrayList;
import java.util.Objects;

public class Storefront {
    private int id;
    private int nextId = 1;

    private String name;

    private String description;

    private ArrayList<Product> products = new ArrayList<>();

    public Storefront(String name, String description, ArrayList<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
        this.id = nextId;
        nextId++;
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

    public int getNextId() {
        return nextId;
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
