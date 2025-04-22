package com.xpenses.transaction.dto;

import lombok.Data;

@Data
public class ApiResponse {
    private int status;
    private String message;
    private IncomeDTO responseBody;
}
