package com.o2xp.repository;

import com.o2xp.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
    public UserProfile findByUsernameAndPassword(String username, String password);
}
