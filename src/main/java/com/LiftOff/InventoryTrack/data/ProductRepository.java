package com.LiftOff.InventoryTrack.data;

import com.LiftOff.InventoryTrack.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
