package com.LiftOff.InventoryTrack.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Product {


    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    private float price;

    private int quantity;

    @ManyToMany(mappedBy = "products")
    private Set<Storefront> storefronts = new HashSet<>();

    public Product() {};

    public Product(String name, String description, float price, int quantity) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }



    public void buyNow()
    {
        if (quantity > 0) {
            this.quantity--;
        }
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Storefront> getStorefronts() {
        return storefronts;
    }

    public void deleteAllStorefronts()
    {
        for (Storefront storefront : this.storefronts)
        {
            storefront.deleteProduct(this);
        }
        this.storefronts.removeAll(this.storefronts);
    }

    public void deleteStorefront(Storefront storefront) {this.storefronts.remove(storefront);
        storefront.getProducts().remove(this);}


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
