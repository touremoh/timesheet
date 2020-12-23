package com.o2xp.repository;

import com.o2xp.model.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProfile, Long> {
}
