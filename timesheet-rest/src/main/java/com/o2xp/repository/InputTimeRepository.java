package com.o2xp.repository;

import com.o2xp.model.InputTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputTimeRepository extends JpaRepository<InputTime, Long> {
}
