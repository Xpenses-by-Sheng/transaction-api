package com.xpenses.transaction.logic.impl;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.entity.Income;
import com.xpenses.transaction.mapper.PutIncomeMapper;
import com.xpenses.transaction.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class IncomePersistLogic implements IncomeLogic {

    private final IncomeRepository incomeRepository;
    private final PutIncomeMapper incomeMapper;

    @Override
    public IncomeDto execute(IncomeDto incomeDto) {
        setEntityDate(incomeDto);
        Income savedIncome = incomeRepository.save(incomeMapper.dtoToEntity(incomeDto));
        return incomeMapper.entityToDto(savedIncome);
    }

    private void setEntityDate(IncomeDto incomeDto) {
        if (incomeDto.getDtRegist() == null)
            incomeDto.setDtInsert(LocalDateTime.now());
        else
            incomeDto.setDtUpdate(LocalDateTime.now());
    }
}
