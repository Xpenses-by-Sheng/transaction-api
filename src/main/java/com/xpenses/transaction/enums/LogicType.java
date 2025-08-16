package com.xpenses.transaction.enums;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.service.LogicMaster;
import com.xpenses.transaction.service.impl.income.IncomeAcquirerLogic;
import com.xpenses.transaction.service.impl.income.IncomeDeleterLogic;
import com.xpenses.transaction.service.impl.income.IncomeInserterLogic;
import com.xpenses.transaction.service.impl.income.IncomeUpdaterLogic;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum LogicType {
    PUT_INCOME(OperationType.PUT_INCOME, IncomeInserterLogic.class),
    GET_INCOME(OperationType.GET_INCOME, IncomeAcquirerLogic.class),
    UPDATE_INCOME(OperationType.UPDATE_INCOME, IncomeUpdaterLogic.class),
    DELETE_INCOME(OperationType.DELETE_INCOME, IncomeDeleterLogic.class);
//    CREATE_EXPENSES(OperationType.CREATE, FinancialType.EXPENSES, ExpensesInserterLogic.class),
//    READ_EXPENSES(OperationType.READ, FinancialType.EXPENSES, ExpensesAcquirerLogic.class),
//    UPDATE_EXPENSES(OperationType.UPDATE, FinancialType.EXPENSES, ExpensesUpdaterLogic.class),
//    DELETE_EXPENSES(OperationType.DELETE, FinancialType.EXPENSES, ExpensesDeleterLogic.class);

    private final OperationType operationType;
    @Getter
    private final Class<? extends LogicMaster> logicClass;

    public static LogicType of(OperationType operation) {
        return Arrays.stream(values())
                .filter(logicType -> logicType.operationType == operation)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ErrorMessages.NO_MATCHING_SELECTOR));
    }
}
