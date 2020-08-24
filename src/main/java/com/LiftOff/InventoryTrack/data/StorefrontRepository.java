package com.LiftOff.InventoryTrack.data;

import com.LiftOff.InventoryTrack.models.Storefront;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorefrontRepository extends CrudRepository<Storefront, Integer> {
}
