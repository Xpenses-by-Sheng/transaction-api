package com.xpenses.transaction.service.impl;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.IncomeDTO;
import com.xpenses.transaction.entity.Income;
import com.xpenses.transaction.repository.IncomeRepository;
import com.xpenses.transaction.service.AcquirerService;
import com.xpenses.transaction.util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("incomeAcquirer")
public class IncomeAcquirerService implements AcquirerService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public void execute(WorkBean workBean) {
        Income query = ObjectMapper.mapObject(workBean.getRequestIncome(), Income.class);
        Optional<Income> optionalIncome = incomeRepository.findById(query.getId());
        optionalIncome.ifPresent(income -> workBean.setResponseIncome(ObjectMapper.mapObject(income, IncomeDTO.class)));
    }
}
