package com.o2xp.controller;

import com.o2xp.model.Customer;
import com.o2xp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> findAll() {
        Optional<List<Customer>> customers = Optional.ofNullable(customerService.findAll());

        if (customers.isPresent()) {
            log.info("Customers found [" + customers.get().size()+"]");
            return new ResponseEntity<>(customers.get(), HttpStatus.OK);
        }
        log.info("Customers not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
