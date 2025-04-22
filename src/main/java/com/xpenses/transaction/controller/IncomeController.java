package com.xpenses.transaction.controller;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.response.ApiResponse;
import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.service.AcquirerService;
import com.xpenses.transaction.service.InserterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        workBean.setRequestBody(request.getRequestBody());

        acquirerService.execute(workBean);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Income data fetched successfully.");
        apiResponse.setResponseBody(workBean.getResponseBody());

        return apiResponse;
    }

    @PostMapping("/put-income")
    public ApiResponse putIncome(@RequestBody ApiRequest request) {
        logger.debug(request.toString());
        WorkBean workBean = new WorkBean();
        workBean.setRequestBody(request.getRequestBody());

        inserterService.execute(workBean);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(200);
        apiResponse.setMessage("Income data inserted successfully.");
        apiResponse.setResponseBody(workBean.getResponseBody());

        return apiResponse;
    }

}
