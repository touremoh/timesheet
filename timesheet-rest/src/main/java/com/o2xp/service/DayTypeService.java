package com.o2xp.service;

import com.o2xp.model.DayType;
import com.o2xp.repository.DayTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DayTypeService implements TimesheetService<DayType> {

    private final DayTypeRepository dayTypeRepository;

    @Override
    public List<DayType> findAll() {
        return this.dayTypeRepository.findAll();
    }

    @Override
    public Optional<DayType> findById(Long id) {
        return this.dayTypeRepository.findById(id);
    }

    @Override
    public DayType save(DayType dayType) {
        return this.dayTypeRepository.save(dayType);
    }

    @Override
    public DayType update(Long id, DayType o) {
        return null;
    }

    @Override
    public void delete(Long id) {
        this.dayTypeRepository.deleteById(id);
    }
}
