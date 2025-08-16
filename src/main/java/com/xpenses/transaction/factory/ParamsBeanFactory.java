package com.xpenses.transaction.factory;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.request.income.IncomeReq;
import com.xpenses.transaction.enums.OperationType;
import org.modelmapper.ModelMapper;

public class ParamsBeanFactory {

    private static final ModelMapper MAPPER = new ModelMapper();

    public static <T extends IncomeReq> IncomeParamsBean build(ApiRequest<T> request, OperationType operationType) {
        IncomeParamsBean paramsBean = new IncomeParamsBean();
        paramsBean.setOperationType(operationType);
        paramsBean.setIncome(MAPPER.map(request.getRequestBody(), IncomeDto.class));
        return paramsBean;
    }

}
