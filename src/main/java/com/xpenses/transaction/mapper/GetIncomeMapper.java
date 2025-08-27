package com.xpenses.transaction.mapper;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.request.income.GetIncomeReq;
import com.xpenses.transaction.enums.OperationType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetIncomeMapper extends IncomeMapper<GetIncomeReq>, MapperOperation {

    @Mapping(source = "dtRegist", target = "dtRegist", dateFormat = DATE_FORMATTER)
    IncomeDto reqToDto(GetIncomeReq incomeReq);

    @Override
    default OperationType getOperationType() {
        return OperationType.GET_INCOME;
    }

}
