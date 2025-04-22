package com.xpenses.transaction.controller;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.ApiRequest;
import com.xpenses.transaction.dto.ApiResponse;
import com.xpenses.transaction.dto.IncomeDTO;
import com.xpenses.transaction.service.AcquirerService;
import com.xpenses.transaction.service.InserterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncomeController {

    private static final Logger logger = LogManager.getLogger(IncomeController.class);

    @Autowired
    @Qualifier("incomeAcquirer")
    private AcquirerService acquirerService;

    @Autowired
    @Qualifier("incomeInserter")
    private InserterService inserterService;

    @PostMapping("/get-income")
    public ApiResponse getIncome(@RequestBody ApiRequest request) {
        logger.debug(request.toString());
        WorkBean workBean = new WorkBean();
        workBean.setRequestIncome(request.getRequestBody());
        workBean.setResponseIncome(new IncomeDTO());

        acquirerService.execute(workBean);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Income data fetched successfully.");
        apiResponse.setResponseBody(workBean.getResponseIncome());

        return apiResponse;
    }

    @PostMapping("/put-income")
    public ApiResponse putIncome(@RequestBody ApiRequest request) {
        logger.debug(request.toString());
        WorkBean workBean = new WorkBean();
        workBean.setRequestIncome(request.getRequestBody());

        inserterService.execute(workBean);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Income data inserted successfully.");
        apiResponse.setResponseBody(workBean.getResponseIncome());

        return apiResponse;
    }

}
