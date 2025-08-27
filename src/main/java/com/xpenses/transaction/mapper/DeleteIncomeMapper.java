package com.xpenses.transaction.mapper;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.request.income.DeleteIncomeReq;
import com.xpenses.transaction.enums.OperationType;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DeleteIncomeMapper extends IncomeMapper<DeleteIncomeReq>, MapperOperation{

    @Mapping(source = "dtRegist", target = "dtRegist", dateFormat = DATE_FORMATTER)
    IncomeDto reqToDto(DeleteIncomeReq incomeReq);

    @Override
    default OperationType getOperationType() {
        return OperationType.DELETE_INCOME;
    }

}
