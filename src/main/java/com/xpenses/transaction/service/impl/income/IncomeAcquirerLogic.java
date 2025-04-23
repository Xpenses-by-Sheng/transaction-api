package com.xpenses.transaction.service.impl.income;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.entity.Income;
import com.xpenses.transaction.repository.IncomeRepository;
import com.xpenses.transaction.service.LogicMaster;
import com.xpenses.transaction.util.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IncomeAcquirerLogic implements LogicMaster {

    private static final Logger logger = LogManager.getLogger(IncomeAcquirerLogic.class);
    private final IncomeRepository incomeRepository;

    @Override
    public void execute(WorkBean workBean) {
        logger.debug("Start {}",this.getClass().getName());
        Income query = ObjectMapper.mapObject(workBean.getRequestBody().getIncome(), Income.class);
        incomeRepository.findById(query.getIncomeId())
                .ifPresent(income -> workBean.getResponseBody().setIncome(ObjectMapper.mapObject(income, IncomeDto.class)));
        logger.debug("End {}",this.getClass().getName());
    }
}
