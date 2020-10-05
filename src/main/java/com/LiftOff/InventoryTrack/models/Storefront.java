package com.LiftOff.InventoryTrack.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Storefront {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    @ManyToMany
    private final List<Product> products = new ArrayList<>();


    public Storefront(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public void deleteProduct(Integer Id)
    {
        this.products.remove(Id);
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

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product)
    {
        this.products.add(product);
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
