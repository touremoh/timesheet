package com.o2xp.repository;

import com.o2xp.model.DayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayTypeRepository extends JpaRepository<DayType, Long> {
}
