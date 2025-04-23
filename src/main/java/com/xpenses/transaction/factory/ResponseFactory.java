package com.xpenses.transaction.factory;

import com.xpenses.transaction.dto.response.ApiResponse;
import com.xpenses.transaction.dto.response.ResponseBody;
import com.xpenses.transaction.util.LogUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseFactory {
    public static ResponseEntity<ApiResponse> build(ResponseBody responseBody) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Operation success.");
        apiResponse.setResponseBody(responseBody);
        LogUtil.outputResponseLog(apiResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    public static ResponseEntity<ApiResponse> build(String errMsg) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(errMsg);
        LogUtil.outputResponseLog(apiResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
