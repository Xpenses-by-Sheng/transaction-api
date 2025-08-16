package com.xpenses.transaction.service.impl.income;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.entity.Income;
import com.xpenses.transaction.repository.IncomeRepository;
import com.xpenses.transaction.service.LogicMaster;
import com.xpenses.transaction.util.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Service
public class IncomeInserterLogic implements LogicMaster {

    private static final Logger logger = LogManager.getLogger(IncomeInserterLogic.class);
    private final IncomeRepository incomeRepository;

    @Override
    public void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean) {
        logger.debug("Start {}", this.getClass().getName());
        IncomeDto incomeDTO = paramsBean.getIncome();
        incomeDTO.setDtInsert(new Timestamp(System.currentTimeMillis()));
        Income savedIncome = incomeRepository.save(ObjectMapper.mapObject(incomeDTO, Income.class));
        responseBean.setIncome(ObjectMapper.mapObject(savedIncome, IncomeDto.class));
        logger.debug("End {}", this.getClass().getName());
    }
}
