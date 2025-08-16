package com.xpenses.transaction.controller;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.request.income.GetIncomeReq;
import com.xpenses.transaction.dto.request.income.PutIncomeReq;
import com.xpenses.transaction.dto.response.ApiResponse;
import com.xpenses.transaction.enums.OperationType;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.factory.ParamsBeanFactory;
import com.xpenses.transaction.factory.ResponseFactory;
import com.xpenses.transaction.service.ServiceMaster;
import com.xpenses.transaction.util.LogUtil;
import com.xpenses.transaction.validator.IncomeRequestValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
public class IncomeController {

    private final ServiceMaster serviceMaster;
    private final IncomeRequestValidator validator;

    @PostMapping("/get-income")
    public ResponseEntity<ApiResponse> getIncome(@RequestBody ApiRequest<GetIncomeReq> request) {
        LogUtil.outputRequestLog(request);

        IncomeParamsBean paramsBean;
        IncomeResponseBean responseBean = new IncomeResponseBean();
        try {
            validator.validate(request);
            paramsBean = ParamsBeanFactory.build(request, OperationType.GET_INCOME);
            serviceMaster.execute(paramsBean, responseBean);
        } catch (ApplicationException e) {
            log.error(e.getMessage());
            return ResponseFactory.build(e.getMessage());
        }

        return ResponseFactory.build(responseBean);
    }

    @PostMapping("/put-income")
    public ResponseEntity<ApiResponse> putIncome(@RequestBody @Valid ApiRequest<PutIncomeReq> request) {
        LogUtil.outputRequestLog(request);

        IncomeParamsBean paramsBean;
        IncomeResponseBean responseBean = new IncomeResponseBean();
        try {
            validator.validate(request);
            paramsBean = ParamsBeanFactory.build(request, OperationType.PUT_INCOME);
            serviceMaster.execute(paramsBean, responseBean);
        } catch (ApplicationException e) {
            log.error(e.getMessage());
            return ResponseFactory.build(e.getMessage());
        }

        return ResponseFactory.build(responseBean);
    }

}
