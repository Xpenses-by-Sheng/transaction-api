package com.xpenses.transaction.controller;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.response.ApiResponse;
import com.xpenses.transaction.enums.FinancialType;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.factory.ResponseFactory;
import com.xpenses.transaction.factory.WorkBeanFactory;
import com.xpenses.transaction.service.ServiceMaster;
import com.xpenses.transaction.util.LogUtil;
import com.xpenses.transaction.validator.IncomeRequestValidator;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class IncomeController {

    private static final Logger logger = LogManager.getLogger(IncomeController.class);

    private final ServiceMaster serviceMaster;
    private final IncomeRequestValidator validator;

    @PostMapping("/get-income")
    public ResponseEntity<ApiResponse> getIncome(@RequestBody ApiRequest request) {
        LogUtil.outputRequestLog(request);

        WorkBean workBean;
        try {
            validator.validate(request);
            workBean = WorkBeanFactory.build(request, FinancialType.INCOME);
            serviceMaster.execute(workBean);
        } catch (ApplicationException e) {
            logger.error(e.getMessage());
            return ResponseFactory.build(e.getMessage());
        }

        return ResponseFactory.build(workBean.getResponseBody());
    }

    @PostMapping("/put-income")
    public ResponseEntity<ApiResponse> putIncome(@RequestBody ApiRequest request) {
        LogUtil.outputRequestLog(request);

        WorkBean workBean;
        try {
            validator.validate(request);
            workBean = WorkBeanFactory.build(request, FinancialType.INCOME);
            serviceMaster.execute(workBean);
        } catch (ApplicationException e) {
            logger.error(e.getMessage());
            return ResponseFactory.build(e.getMessage());
        }

        return ResponseFactory.build(workBean.getResponseBody());
    }

}
