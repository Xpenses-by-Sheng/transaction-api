package com.xpenses.transaction.service.impl.income;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;
import com.xpenses.transaction.service.CommonService;

public interface IncomeService extends CommonService {
    void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean);
}
