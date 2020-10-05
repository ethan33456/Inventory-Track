package com.LiftOff.InventoryTrack.data;

import com.LiftOff.InventoryTrack.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
