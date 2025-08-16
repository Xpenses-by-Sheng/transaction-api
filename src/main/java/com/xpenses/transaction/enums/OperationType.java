package com.xpenses.transaction.enums;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.exception.ApplicationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum OperationType {
    GET_INCOME("getIncome"),
    PUT_INCOME("putIncome"),
    UPDATE_INCOME("updateIncome"),
    DELETE_INCOME("deleteIncome");

    private final String operationType;

    public static OperationType of(String type) {
        return Arrays.stream(values())
                .filter(operationType -> operationType.name().equals(type))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ErrorMessages.INVALID_OPERATION_TYPE));
    }
}
