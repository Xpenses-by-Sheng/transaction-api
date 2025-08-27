package com.xpenses.transaction.enums;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.logic.LogicMaster;
import com.xpenses.transaction.logic.impl.IncomeAcquirerLogic;
import com.xpenses.transaction.logic.impl.IncomeDeleterLogic;
import com.xpenses.transaction.logic.impl.IncomePersistLogic;
import com.xpenses.transaction.service.CommonService;
import com.xpenses.transaction.service.impl.income.GetIncomeService;
import com.xpenses.transaction.service.impl.income.PutIncomeService;
import com.xpenses.transaction.service.impl.income.UpdateIncomeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum LogicType {
    GET_INCOME(OperationType.GET_INCOME, GetIncomeService.class, IncomeAcquirerLogic.class),
    PUT_INCOME(OperationType.PUT_INCOME, PutIncomeService.class, IncomePersistLogic.class),
    UPDATE_INCOME(OperationType.UPDATE_INCOME, UpdateIncomeService.class, IncomePersistLogic.class),
    DELETE_INCOME(OperationType.DELETE_INCOME, null, IncomeDeleterLogic.class);

    private final OperationType operationType;
    private final Class<? extends CommonService> serviceClass;
    private final Class<? extends LogicMaster> logicClass;

    public static LogicType of(OperationType operation) {
        return Arrays.stream(values())
                .filter(logicType -> logicType.operationType == operation)
                .findFirst()
                .orElseThrow(() -> new ApplicationException(ErrorMessages.NO_MATCHING_SELECTOR));
    }
}
