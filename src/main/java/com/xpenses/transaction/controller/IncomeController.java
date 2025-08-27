package com.xpenses.transaction.controller;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.request.income.GetIncomeReq;
import com.xpenses.transaction.dto.request.income.IncomeReq;
import com.xpenses.transaction.dto.request.income.PutIncomeReq;
import com.xpenses.transaction.dto.request.income.UpdateIncomeReq;
import com.xpenses.transaction.dto.response.ApiResponse;
import com.xpenses.transaction.enums.OperationType;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.factory.ParamsBeanFactory;
import com.xpenses.transaction.factory.ResponseFactory;
import com.xpenses.transaction.service.ServiceMaster;
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

    private final ParamsBeanFactory paramsBeanFactory;
    private final ServiceMaster serviceMaster;
    private final IncomeRequestValidator validator;

    @PostMapping("/get-income")
    public ResponseEntity<ApiResponse> getIncome(@RequestBody ApiRequest<GetIncomeReq> request) {
        return handleReq(request, OperationType.GET_INCOME);
    }

    @PostMapping("/put-income")
    public ResponseEntity<ApiResponse> putIncome(@RequestBody @Valid ApiRequest<PutIncomeReq> request) {
        return handleReq(request, OperationType.PUT_INCOME);
    }

    @PostMapping("/update-income")
    public ResponseEntity<ApiResponse> updateIncome(@RequestBody @Valid ApiRequest<UpdateIncomeReq> request) {
        return handleReq(request, OperationType.UPDATE_INCOME);
    }

    @PostMapping("/delete-income")
    public ResponseEntity<ApiResponse> deleteIncome(@RequestBody @Valid ApiRequest<UpdateIncomeReq> request) {
        return handleReq(request, OperationType.UPDATE_INCOME);
    }

    public <T extends IncomeReq> ResponseEntity<ApiResponse> handleReq(ApiRequest<T> request, OperationType operationType) {
        IncomeParamsBean paramsBean;
        IncomeResponseBean responseBean = new IncomeResponseBean();
        try {
            validator.validate(request);
            paramsBean = paramsBeanFactory.build(request, operationType);
            serviceMaster.execute(paramsBean, responseBean);
        } catch (ApplicationException e) {
            log.error(e.getMessage());
            return ResponseFactory.build(e.getMessage());
        }

        return ResponseFactory.build(responseBean);
    }

}
