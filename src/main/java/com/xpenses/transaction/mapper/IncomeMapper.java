package com.xpenses.transaction.mapper;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.request.income.IncomeReq;
import com.xpenses.transaction.entity.Income;

public interface IncomeMapper<T extends IncomeReq> {

    String DATE_FORMATTER = "yyyy-MM-dd";

    IncomeDto reqToDto(T incomeReq);
    IncomeDto entityToDto(Income entity);
    Income dtoToEntity(IncomeDto dto);
}
