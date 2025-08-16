package com.xpenses.transaction.validator;

import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.request.income.IncomeReq;
import org.springframework.stereotype.Component;

@Component
public class IncomeRequestValidator extends RequestValidator {

    @Override
    public <T extends IncomeReq> void validateAdditional(ApiRequest<T> request) {
        // TODO: implement request validation
    }

}
