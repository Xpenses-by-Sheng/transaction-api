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
    CREATE_INCOME(OperationType.CREATE, FinancialType.INCOME, IncomeInserterLogic.class),
    READ_INCOME(OperationType.READ, FinancialType.INCOME, IncomeAcquirerLogic.class),
    UPDATE_INCOME(OperationType.UPDATE, FinancialType.INCOME, IncomeUpdaterLogic.class),
    DELETE_INCOME(OperationType.DELETE, FinancialType.INCOME, IncomeDeleterLogic.class);
//    CREATE_EXPENSES(OperationType.CREATE, FinancialType.EXPENSES, ExpensesInserterLogic.class),
//    READ_EXPENSES(OperationType.READ, FinancialType.EXPENSES, ExpensesAcquirerLogic.class),
//    UPDATE_EXPENSES(OperationType.UPDATE, FinancialType.EXPENSES, ExpensesUpdaterLogic.class),
//    DELETE_EXPENSES(OperationType.DELETE, FinancialType.EXPENSES, ExpensesDeleterLogic.class);

    private final OperationType operationType;
    private final FinancialType financialType;
    @Getter
    private final Class<? extends LogicMaster> logicClass;

    public static LogicType of(OperationType operation, FinancialType financial) {
        return Arrays.stream(values())
                .filter(logicType ->
                        logicType.operationType == operation && logicType.financialType == financial)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ErrorMessages.NO_MATCHING_SELECTOR));
    }
}
