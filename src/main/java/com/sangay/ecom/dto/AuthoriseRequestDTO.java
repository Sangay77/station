package com.sangay.ecom.dto;


import lombok.Data;

@Data
public class AuthoriseRequestDTO {

    private String accountNumber;
    private String bfs_paymentDesc;
    private String txnAmount;
}
