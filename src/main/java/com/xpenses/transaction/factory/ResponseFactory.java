package com.xpenses.transaction.factory;

import com.xpenses.transaction.dto.response.ApiResponse;
import com.xpenses.transaction.dto.IncomeResponseBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
    public static ResponseEntity<ApiResponse> build(IncomeResponseBean responseBody) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Operation success.");
        apiResponse.setResponseBody(responseBody);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public static ResponseEntity<ApiResponse> build(String errMsg) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(errMsg);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
