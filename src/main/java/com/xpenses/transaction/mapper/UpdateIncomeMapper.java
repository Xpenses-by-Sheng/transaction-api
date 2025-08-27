package com.xpenses.transaction.mapper;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.request.income.UpdateIncomeReq;
import com.xpenses.transaction.enums.OperationType;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UpdateIncomeMapper extends IncomeMapper<UpdateIncomeReq>, MapperOperation{

    @Mapping(source = "dtRegist", target = "dtRegist", dateFormat = DATE_FORMATTER)
    IncomeDto reqToDto(UpdateIncomeReq incomeReq);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void dtoToDto(IncomeDto source, @MappingTarget IncomeDto target);

    @Override
    default OperationType getOperationType() {
        return OperationType.UPDATE_INCOME;
    }

}
