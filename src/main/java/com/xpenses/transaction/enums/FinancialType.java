package com.xpenses.transaction.enums;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.exception.ApplicationException;

import java.util.Arrays;

public enum FinancialType {
    INCOME,
    EXPENSES;

    public static FinancialType of(String type) {
        return Arrays.stream(values())
                .filter(financialType -> financialType.name().equals(type))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ErrorMessages.INVALID_FINANCIAL_TYPE));
    }
}
