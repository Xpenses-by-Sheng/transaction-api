package com.xpenses.transaction.logic.impl;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class IncomeDeleterLogic implements IncomeLogic {

    private final IncomeRepository incomeRepository;

    @Override
    public IncomeDto execute(IncomeDto incomeDto) {
        incomeRepository.deleteById(incomeDto.getIncomeId());
        return null;
    }
}
