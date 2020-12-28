package com.o2xp.controller;

import com.o2xp.model.Customer;
import com.o2xp.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Operation(summary = "Customers finding service", description = "Finding all customers")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the list of customers found",
            content = { @Content(schema = @Schema(anyOf = { Customer.class })) }
    )
    @ApiResponse(
            responseCode = "400",
            description = "No customer was found in the DB",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> findAll() {
        Optional<List<Customer>> customers = Optional.ofNullable(customerService.findAll());

        if (customers.isPresent()) {
            log.info("Customers found [" + customers.get().size()+"]");
            return new ResponseEntity<>(customers.get(), HttpStatus.OK);
        }
        log.warn("Customers not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Customers finding service", description = "Finding customer by ID")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the customer found based on his ID",
            content = { @Content(schema = @Schema(anyOf = { Customer.class })) }
    )
    @ApiResponse(
            responseCode = "400",
            description = "No customer was found in the DB",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Optional<Customer> customer = this.customerService.findById(id);

        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        log.warn("Customer with ID ["+id+"] not found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Customers creation service", description = "Creating new customer")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the created customer",
            content = { @Content(schema = @Schema(anyOf = { Customer.class })) }
    )
    @ApiResponse(
            responseCode = "400",
            description = "No customer was found in the DB",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody  Customer newCustomer) {
        Customer customerSaved = this.customerService.save(newCustomer);

        if (newCustomer.getReference().equals(customerSaved.getReference())) {
            log.info("Customer created");
            return new ResponseEntity<>(customerSaved, HttpStatus.OK);
        }
        log.warn("Customer not created");
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
