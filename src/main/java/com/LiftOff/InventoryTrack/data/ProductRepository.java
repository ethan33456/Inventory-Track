package com.LiftOff.InventoryTrack.data;

import com.LiftOff.InventoryTrack.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("update Product p SET p.name = ?1, p.description = ?2, p.price = ?3, p.quantity= ?4 where p.id = ?5")
    void updateProductById(String name, String description, float price, int quantity, int id);
}
