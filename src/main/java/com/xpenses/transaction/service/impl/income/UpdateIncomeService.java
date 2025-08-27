package com.xpenses.transaction.service.impl.income;

import com.xpenses.transaction.constants.ErrorMessages;
import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.enums.OperationType;
import com.xpenses.transaction.exception.ApplicationException;
import com.xpenses.transaction.logic.impl.IncomeAcquirerLogic;
import com.xpenses.transaction.logic.impl.IncomePersistLogic;
import com.xpenses.transaction.mapper.UpdateIncomeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class UpdateIncomeService implements IncomeService {

    private final UpdateIncomeMapper updateIncomeMapper;
    private final IncomeAcquirerLogic incomeAcquirerLogic;
    private final IncomePersistLogic incomePersistLogic;

    @Override
    public void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean) {
        IncomeDto updateTarget = incomeAcquirerLogic.execute(paramsBean.getIncome());
        if (Objects.isNull(updateTarget))
            throw new ApplicationException(ErrorMessages.NO_EXISTING_DATA);
        updateIncomeMapper.dtoToDto(paramsBean.getIncome(), updateTarget);
        responseBean.setIncome(incomePersistLogic.execute(updateTarget));
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.UPDATE_INCOME;
    }
}
