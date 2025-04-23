package com.xpenses.transaction.factory;

import com.xpenses.transaction.common.WorkBean;
import com.xpenses.transaction.dto.request.ApiRequest;
import com.xpenses.transaction.enums.FinancialType;
import com.xpenses.transaction.enums.OperationType;

public class WorkBeanFactory {

    public static WorkBean build(ApiRequest request, FinancialType financialType) {
        WorkBean workBean = new WorkBean();

        workBean.setOperationType(OperationType.of(request.getOperation()));
        workBean.setFinancialType(financialType);
        workBean.setRequestBody(request.getRequestBody());

        return workBean;
    }

}
