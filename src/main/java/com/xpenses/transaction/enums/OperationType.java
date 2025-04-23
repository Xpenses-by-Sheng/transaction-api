package com.xpenses.transaction.enums;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.exception.ApplicationException;

import java.util.Arrays;

public enum OperationType {
    CREATE,
    READ,
    UPDATE,
    DELETE;

    public static OperationType of(String type) {
        return Arrays.stream(values())
                .filter(operationType -> operationType.name().equals(type))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ErrorMessages.INVALID_OPERATION_TYPE));
    }
}
