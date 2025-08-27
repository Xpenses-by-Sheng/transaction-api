package com.xpenses.transaction.logic.impl;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.mapper.PutIncomeMapper;
import com.xpenses.transaction.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IncomeAcquirerLogic implements IncomeLogic {

    private final IncomeRepository incomeRepository;
    private final PutIncomeMapper incomeMapper;

    @Override
    public IncomeDto execute(IncomeDto incomeDto) {
        return incomeMapper.entityToDto(incomeRepository.findById(incomeDto.getIncomeId()).orElse(null));
    }
}
