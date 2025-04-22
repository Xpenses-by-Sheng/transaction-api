package com.xpenses.transaction.service.impl;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.entity.Income;
import com.xpenses.transaction.repository.IncomeRepository;
import com.xpenses.transaction.service.AcquirerService;
import com.xpenses.transaction.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("incomeAcquirer")
public class IncomeAcquirerService implements AcquirerService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public void execute(WorkBean workBean) {
        Income query = ObjectMapper.mapObject(workBean.getRequestBody().getIncome(), Income.class);
        incomeRepository.findById(query.getIncomeId())
                .ifPresent(income -> workBean.getResponseBody().setIncome(ObjectMapper.mapObject(income, IncomeDto.class)));
    }
}
