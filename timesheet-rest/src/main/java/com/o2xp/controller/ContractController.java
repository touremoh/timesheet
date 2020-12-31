package com.o2xp.controller;


import com.o2xp.dto.ContractDTO;
import com.o2xp.mapper.ContractMapper;
import com.o2xp.model.Contract;
import com.o2xp.model.Customer;
import com.o2xp.model.Task;
import com.o2xp.service.ContractService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService service;

    @Operation(summary = "Contract creation service", description = "Creating a new contract")
    @ApiResponse(
            responseCode = "201",
            description = "Returns the contract that was created",
            content = { @Content(schema = @Schema(anyOf = { Task.class })) }
    )
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> addNewContract(@RequestBody ContractDTO newContract) {

        Contract contractModel = ContractMapper.INSTANCE.toModel(newContract);
        Optional<Contract> createResponse = Optional.ofNullable(this.service.save(contractModel));
        return createResponse
                .map(contract -> {
                    ContractDTO contractDTO = ContractMapper.INSTANCE.toDTO(contract);
                    return new ResponseEntity<>(contractDTO, HttpStatus.CREATED);
                })
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED));
    }

    @Operation(summary = "Contracts finding service", description = "Finding all contracts")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the list of contracts found",
            content = { @Content(schema = @Schema(anyOf = { Customer.class })) }
    )
    @ApiResponse(
            responseCode = "404",
            description = "No contract was found",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContractDTO>> findAllContracts() {
        Optional<List<Contract>> optionalList = Optional.ofNullable(this.service.findAll());
        return optionalList
                .map(contracts -> {
                    log.info("Contracts found ["+contracts.size()+"]");
                    List<ContractDTO> contractDTOS = new ArrayList<>();
                    contracts.forEach(contract -> contractDTOS.add(ContractMapper.INSTANCE.toDTO(contract)));
                    return new ResponseEntity<>(contractDTOS, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    log.warn("No contract was found");
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                });
    }

    @Operation(summary = "Contracts finding service", description = "Finding one contract")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the contract that was found",
            content = { @Content(schema = @Schema(anyOf = { Customer.class })) }
    )
    @ApiResponse(
            responseCode = "404",
            description = "No contract was found",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> findContractById(Long id) {
        Optional<Contract> optionalContract = this.service.findById(id);
        return optionalContract
                .map(contract -> new ResponseEntity<>(ContractMapper.INSTANCE.toDTO(contract), HttpStatus.OK))
                .orElseGet(() -> {
                    log.warn("No contract was found with ID ["+id+"]");
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                });
    }


    @Operation(summary = "Contracts updating service", description = "Updating one contract")
    @ApiResponse(
            responseCode = "201",
            description = "Returns the contract that was updated",
            content = { @Content(schema = @Schema(anyOf = { Customer.class })) }
    )
    @ApiResponse(
            responseCode = "404",
            description = "No contract to update was found",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContractDTO> updateContract(@PathVariable Long id, @RequestBody ContractDTO contractDTO) {
        Optional<Contract> optionalContract =
                Optional.ofNullable(this.service.update(id, ContractMapper.INSTANCE.toModel(contractDTO)));

        return optionalContract
                .map(contract -> new ResponseEntity<>(ContractMapper.INSTANCE.toDTO(contract), HttpStatus.CREATED))
                .orElseGet(() -> {
                    log.warn("The contract was not updated");
                    return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
                });
    }

    @Operation(summary = "Contract deletion service", description = "Delete an existing contract")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContract(@PathVariable Long id) {
        this.service.delete(id);
    }

}
