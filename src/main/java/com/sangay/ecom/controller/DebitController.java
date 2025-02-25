package com.sangay.ecom.controller;

import com.sangay.ecom.dto.DebitRequestDTO;
import com.sangay.ecom.service.DebitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/debit")
public class DebitController {

    private final DebitService debitService;

    private static final Logger logger = LoggerFactory.getLogger(DebitController.class);

    public DebitController(DebitService debitService) {
        this.debitService = debitService;
    }

    @PostMapping
    public String debit(@RequestBody DebitRequestDTO debitRequestDTO) {
        logger.info("Debit Controller request thread: {}", Thread.currentThread().getName());
        return debitService.debit(debitRequestDTO);
    }

}
