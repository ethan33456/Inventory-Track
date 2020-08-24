package com.LiftOff.InventoryTrack.data;

import com.LiftOff.InventoryTrack.models.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductData {
    private static final Map<Integer, Product> products = new HashMap<>();

    public static Collection<Product> getAll() {
        return products.values();
    }

    public static Product getById(int id) {
        return products.get(id);
    }

    public static void add(Product product) {
        products.put(product.getId(), product);
    }

    public static void remove(int id) {
        products.remove(id);
    }
}
