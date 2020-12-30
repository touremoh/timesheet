package com.o2xp.controller;


import com.o2xp.dto.ContractDTO;
import com.o2xp.mapper.ContractMapper;
import com.o2xp.model.Contract;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contract>> findAllContracts() {
        Optional<List<Contract>> optionalList = Optional.ofNullable(this.service.findAll());
        return optionalList
                .map(contracts -> {
                    log.info("Contracts found ["+contracts.size()+"]");
                    return new ResponseEntity<>(contracts, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    log.warn("No contract was found");
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                });
    }
}
