package com.o2xp.controller;

import com.o2xp.model.UserProfile;
import com.o2xp.repository.UserRepository;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Operation(summary = "UserProfile finding service", description = "Finding a user based on his ID")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the user found",
            content = { @Content(schema = @Schema(anyOf = { UserProfile.class })) }
    )
    @ApiResponse(
            responseCode = "400",
            description = "Missing required parameter",
            content = { @Content(schema = @Schema(hidden = true)) }
    )
    @GetMapping(path ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserProfile> findOne(@PathVariable Long id) {
        log.info(String.valueOf(id));
        Optional<UserProfile> userFound = userRepository.findById(id);

        if (userFound.isPresent()) {
            log.info("UserProfile found" + userFound.get().getFirstName());
            return new ResponseEntity<UserProfile>(userFound.get(), HttpStatus.OK);
        }
        log.info("UserProfile not found");
        return new ResponseEntity<UserProfile>(HttpStatus.NOT_FOUND);
    }
}
