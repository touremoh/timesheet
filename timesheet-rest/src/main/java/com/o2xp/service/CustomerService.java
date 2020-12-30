package com.o2xp.service;

import com.o2xp.model.Customer;
import com.o2xp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements TimesheetService<Customer> {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public void delete(Long customerId) {
        this.customerRepository.deleteById(customerId);
    }

    public Customer updateCustomer(Long id, Customer newData) {
        Optional<Customer> customerToUpdate = this.customerRepository.findById(id);

        if (customerToUpdate.isPresent()) {
            Customer customer = customerToUpdate.get();
            if (newData.hasReference()) {
                customer.setReference(newData.getReference());
            }
            if (newData.hasName()) {
                customer.setName(customer.getName());
            }
            customer.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return this.customerRepository.save(customer);
        }
        return null;
    }
}
