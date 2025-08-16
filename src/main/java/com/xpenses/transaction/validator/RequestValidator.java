package com.xpenses.transaction.validator;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.request.income.IncomeReq;
import com.xpenses.transaction.exception.ApplicationException;
import org.apache.commons.lang3.StringUtils;

public abstract class RequestValidator {

    public <T extends IncomeReq> void validate(ApiRequest<T> request) {
        if (StringUtils.isBlank(request.getClient()))
            throw new ApplicationException(ErrorMessages.EMPTY_CLIENT);
        validateAdditional(request);
    }

    public abstract <T extends IncomeReq> void validateAdditional(ApiRequest<T> request);

}
