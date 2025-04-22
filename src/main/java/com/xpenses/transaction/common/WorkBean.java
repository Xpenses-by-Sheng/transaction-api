package com.xpenses.transaction.common;

import com.xpenses.transaction.dto.request.RequestBody;
import com.xpenses.transaction.dto.response.ResponseBody;
import com.xpenses.transaction.enums.OperationType;
import lombok.Data;

@Data
public class WorkBean {
    private OperationType operationType;
    private RequestBody requestBody;
    private ResponseBody responseBody;

    public RequestBody getRequestBody() {
        if (requestBody == null)
            requestBody = new RequestBody();
        return requestBody;
    }

    public ResponseBody getResponseBody() {
        if (responseBody == null)
            responseBody = new ResponseBody();
        return responseBody;
    }
}
