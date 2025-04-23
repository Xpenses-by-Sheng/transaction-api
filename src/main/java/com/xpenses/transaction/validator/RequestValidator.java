package com.xpenses.transaction.validator;

import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.dto.request.ApiRequest;
import org.apache.commons.lang3.StringUtils;

public abstract class RequestValidator {

    public void validate(ApiRequest request) {
        if(StringUtils.isBlank(request.getClient()))
            throw new ApplicationException(ErrorMessages.EMPTY_CLIENT);
        if(StringUtils.isBlank(request.getOperation()))
            throw new ApplicationException(ErrorMessages.EMPTY_OPERATION_TYPE);
        if(request.getRequestBody() == null)
            throw new ApplicationException(ErrorMessages.EMPTY_REQUEST_BODY);
        validateAdditional(request);
    }

    public abstract void validateAdditional(ApiRequest request);

}
