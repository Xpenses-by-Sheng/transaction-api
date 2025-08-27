package com.xpenses.transaction.service;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.enums.LogicType;
import com.xpenses.transaction.service.impl.income.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ServiceMaster {

    private final ServiceRegistry serviceRegistry;

    public void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean) {
        LogicType logicType = LogicType.of(paramsBean.getOperationType());
        IncomeService service = serviceRegistry.getService(logicType);
        service.execute(paramsBean, responseBean);
    }

}
