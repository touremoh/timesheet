package com.o2xp.service;

import com.o2xp.model.InputTime;
import com.o2xp.repository.InputTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InputTimeService implements TimesheetService<InputTime> {

    private final InputTimeRepository inputTimeRepository;

    @Override
    public List<InputTime> findAll() {
        return this.inputTimeRepository.findAll();
    }

    @Override
    public Optional<InputTime> findById(Long id) {
        return this.inputTimeRepository.findById(id);
    }

    @Override
    public InputTime save(InputTime inputTime) {
        return this.inputTimeRepository.save(inputTime);
    }

    @Override
    public InputTime update(Long id, InputTime o) {
        return null;
    }

    @Override
    public void delete(Long id) {
        this.inputTimeRepository.deleteById(id);
    }
}
