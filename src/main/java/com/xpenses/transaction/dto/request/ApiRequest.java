package com.xpenses.transaction.dto.request;

import lombok.Data;

@Data
public class ApiRequest {
    private String client;
    private String operation;
    private RequestBody requestBody;
}
