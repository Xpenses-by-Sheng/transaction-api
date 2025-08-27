package com.xpenses.transaction.enums;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.service.CommonService;
import com.xpenses.transaction.service.impl.income.DeleteIncomeService;
import com.xpenses.transaction.service.impl.income.GetIncomeService;
import com.xpenses.transaction.service.impl.income.PutIncomeService;
import com.xpenses.transaction.service.impl.income.UpdateIncomeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum OperationType {
    GET_INCOME("getIncome", GetIncomeService.class),
    PUT_INCOME("putIncome", PutIncomeService.class),
    UPDATE_INCOME("updateIncome", UpdateIncomeService.class),
    DELETE_INCOME("deleteIncome", DeleteIncomeService.class);

    private final String operationType;
    private final Class<? extends CommonService> serviceClass;

    public static OperationType of(String type) {
        return Arrays.stream(values())
                .filter(operationType -> operationType.name().equals(type))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ErrorMessages.INVALID_OPERATION_TYPE));
    }
}
