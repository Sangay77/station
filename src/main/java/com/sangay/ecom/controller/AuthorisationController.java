package com.sangay.ecom.controller;

import com.sangay.ecom.dto.AuthoriseRequestDTO;
import com.sangay.ecom.service.AuthoriseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/authorise")
public class AuthorisationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorisationController.class);

    private final AuthoriseService authorisationService;

    public AuthorisationController(AuthoriseService authorisationService) {
        this.authorisationService = authorisationService;
    }

    @GetMapping
    public Map<String, String> authorise(@RequestBody AuthoriseRequestDTO request) throws Exception {
        // Log request thread, which is the controller's thread
        logger.info("Controller request thread: {}", Thread.currentThread().getName());

        // Execute the asynchronous authorization service method
        return authorisationService.authService(request);
    }
}
