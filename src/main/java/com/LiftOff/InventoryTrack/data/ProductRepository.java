package com.LiftOff.InventoryTrack.data;

import com.LiftOff.InventoryTrack.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.name = :name, p.description = :description, p.price = :price, p.quantity= :quantity WHERE p.id = :id")
    void updateProductById(@Param("name") String name,@Param("description") String description,@Param("price") float price,@Param("quantity") int quantity,@Param("id") Integer id);
}
