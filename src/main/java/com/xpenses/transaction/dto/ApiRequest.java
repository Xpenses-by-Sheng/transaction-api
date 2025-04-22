package com.xpenses.transaction.dto;

import lombok.Data;

@Data
public class ApiRequest {
    private String client;
    private IncomeDTO requestBody;
}
