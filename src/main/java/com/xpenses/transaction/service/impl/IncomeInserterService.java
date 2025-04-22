package com.xpenses.transaction.service.impl;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.entity.Income;
import com.xpenses.transaction.repository.IncomeRepository;
import com.xpenses.transaction.service.InserterService;
import com.xpenses.transaction.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Qualifier("incomeInserter")
public class IncomeInserterService implements InserterService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public void execute(WorkBean workBean) {
        IncomeDto incomeDTO = workBean.getRequestBody().getIncome();
        incomeDTO.setDtInsert(new Timestamp(System.currentTimeMillis()));
        Income savedIncome = incomeRepository.save(ObjectMapper.mapObject(incomeDTO, Income.class));
        workBean.getResponseBody().setIncome(ObjectMapper.mapObject(savedIncome, IncomeDto.class));
    }
}
