package com.xpenses.transaction.service.impl.income;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.enums.OperationType;
import com.xpenses.transaction.logic.impl.IncomePersistLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PutIncomeService implements IncomeService {

    private final IncomePersistLogic incomePersistLogic;

    @Override
    public void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean) {
        responseBean.setIncome(incomePersistLogic.execute(paramsBean.getIncome()));
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.PUT_INCOME;
    }
}
