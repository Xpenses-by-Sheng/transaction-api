package com.xpenses.transaction.dto.response;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private ResponseBody responseBody;
}
