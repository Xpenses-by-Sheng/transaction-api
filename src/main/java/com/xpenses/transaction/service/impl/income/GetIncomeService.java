package com.xpenses.transaction.service.impl.income;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.enums.OperationType;
import com.xpenses.transaction.logic.impl.IncomeAcquirerLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetIncomeService implements IncomeService {

    private final IncomeAcquirerLogic incomeAcquirerLogic;

    @Override
    public void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean) {
        responseBean.setIncome(incomeAcquirerLogic.execute(paramsBean.getIncome()));;
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.GET_INCOME;
    }
}
