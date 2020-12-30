package com.o2xp.service;

import com.o2xp.model.Contract;
import com.o2xp.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    @Override
    public Contract update(Long id, Contract newData) {
        Optional<Contract> optionalContract = this.contractRepository.findById(id);

        if (optionalContract.isPresent()) {
            Contract contract = optionalContract.get();
            if (newData.hasUser()) {
                contract.setUserProfile(newData.getUserProfile());
            }
            if (newData.hasCustomer()) {
                contract.setCustomer(newData.getCustomer());
            }
            if (newData.hasStartingDt()) {
                contract.setStartingDt(newData.getStartingDt());
            }
            if (newData.hasEndingDt()) {
                contract.setEndingDt(newData.getEndingDt());
            }
            contract.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return this.contractRepository.save(contract);
        }
        return null;
    }
}
