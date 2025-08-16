package com.xpenses.transaction.dto.response;

import com.xpenses.transaction.dto.IncomeResponseBean;
import lombok.Data;

import java.util.Map;

@Data
public class ApiResponse {
    private String message;
    private Map<String, String> messageMap;
    private IncomeResponseBean responseBody;
}
