package com.xpenses.transaction.validator;

import com.xpenses.transaction.dto.request.ApiRequest;
import org.springframework.stereotype.Component;

@Component
public class IncomeRequestValidator extends RequestValidator {

    @Override
    public void validateAdditional(ApiRequest request) {
        // TODO: implement request validation
    }

}
