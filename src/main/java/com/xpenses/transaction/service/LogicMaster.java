package com.xpenses.transaction.service;

import com.xpenses.transaction.dto.IncomeParamsBean;
import com.xpenses.transaction.dto.IncomeResponseBean;

public interface LogicMaster {
    void execute(IncomeParamsBean paramsBean, IncomeResponseBean responseBean);
}
