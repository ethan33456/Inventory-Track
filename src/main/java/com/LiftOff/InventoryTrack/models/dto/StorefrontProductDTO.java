package com.LiftOff.InventoryTrack.models.dto;

import com.LiftOff.InventoryTrack.data.ProductRepository;
import com.LiftOff.InventoryTrack.models.Product;
import com.LiftOff.InventoryTrack.models.Storefront;
import com.sun.istack.NotNull;
import org.springframework.data.repository.CrudRepository;

public class StorefrontProductDTO {

    private final CrudRepository crudRepository;

    @NotNull
    private Storefront storefront;

    @NotNull
    private Product product;

    public StorefrontProductDTO() {}

    public Storefront getStorefront() {
        this.crudRepository = crudRepository;
        return storefront;
    }

    public void setStorefront(Storefront storefront) {
        this.storefront = storefront;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public void delete(Integer id)
    {
        crudRepository.findById(id);
        this.delete();
    }


}
