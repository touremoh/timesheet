package com.o2xp.service;

import com.o2xp.model.Contract;
import com.o2xp.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ContractService implements TimesheetService<Contract> {

    private final ContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return this.contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return this.contractRepository.findById(id);
    }

    @Override
    public Contract save(Contract contract) {
        return this.contractRepository.save(contract);
    }

    @Override
    public void delete(Long id) {
        this.contractRepository.deleteById(id);
    }
}
