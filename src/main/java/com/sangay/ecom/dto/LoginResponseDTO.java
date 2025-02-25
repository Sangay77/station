package com.sangay.ecom.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LoginResponseDTO {
    private String status;
    private String message;
    private Object data;
}