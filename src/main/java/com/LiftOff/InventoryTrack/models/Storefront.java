package com.LiftOff.InventoryTrack.models;


import javax.persistence.*;
import java.util.*;

@Entity
public class Storefront {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    @ManyToMany
    private Set<Product> products = new HashSet<>();

    public Storefront() {};

    public Storefront(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }


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

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product)
    {
        this.products.add(product);
    }

    public void deleteProduct(Product product) {this.products.remove(product);
    product.getStorefronts().remove(this);}

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
