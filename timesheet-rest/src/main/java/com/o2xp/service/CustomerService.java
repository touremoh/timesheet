package com.o2xp.service;

import com.o2xp.model.Customer;
import com.o2xp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
