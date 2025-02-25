package com.sangay.ecom.controller;

import com.sangay.ecom.dto.AccountInquiryDTO;
import com.sangay.ecom.service.EnquiryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    private static final Logger logger = LoggerFactory.getLogger(EnquiryController.class);

    private final EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }


    @PostMapping
    public String Enquiry(@RequestBody AccountInquiryDTO accountInquiryDTO) throws Exception {
        // Log request thread, which is the controller's thread
        logger.info("Controller request thread: {}", Thread.currentThread().getName());
        return enquiryService.accountEnquiry(accountInquiryDTO);
    }
}
