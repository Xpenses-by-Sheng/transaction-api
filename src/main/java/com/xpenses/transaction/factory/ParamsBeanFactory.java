package com.xpenses.transaction.factory;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.dto.request.income.IncomeReq;
import com.xpenses.transaction.enums.OperationType;
import com.xpenses.transaction.mapper.IncomeMapper;
import com.xpenses.transaction.mapper.MapperOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ParamsBeanFactory {

    private final Map<OperationType, MapperOperation> mapperRegistry = new HashMap<>();

    public ParamsBeanFactory(List<MapperOperation> incomeMapperList) {
        for (MapperOperation incomeMapper : incomeMapperList) {
            mapperRegistry.put(incomeMapper.getOperationType(), incomeMapper);
            log.info(incomeMapper.toString());
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends IncomeReq> IncomeParamsBean build(ApiRequest<T> request, OperationType operationType) {
        IncomeParamsBean paramsBean = new IncomeParamsBean();
        paramsBean.setOperationType(operationType);
        IncomeMapper<T> mapper = (IncomeMapper<T>) mapperRegistry.get(operationType);
        paramsBean.setIncome(mapper.reqToDto(request.getRequestBody()));
        return paramsBean;
    }



}
