package com.xpenses.transaction.service.impl.income;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.enums.OperationType;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.logic.impl.IncomeAcquirerLogic;
import com.xpenses.transaction.logic.impl.IncomeDeleterLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteIncomeService implements IncomeService {

    private final IncomeAcquirerLogic incomeAcquirerLogic;
    private final IncomeDeleterLogic incomeDeleterLogic;

    @Override
    public void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean) {
        IncomeDto existingTarget = incomeAcquirerLogic.execute(paramsBean.getIncome());
        if (Objects.isNull(existingTarget))
            throw new ApplicationException(ErrorMessages.NO_EXISTING_DATA);
        incomeDeleterLogic.execute(paramsBean.getIncome());
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.DELETE_INCOME;
    }
}
