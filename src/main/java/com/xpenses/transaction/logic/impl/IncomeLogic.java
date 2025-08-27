package com.xpenses.transaction.logic.impl;

import com.xpenses.transaction.dto.IncomeDto;
import com.xpenses.transaction.logic.LogicMaster;

public interface IncomeLogic extends LogicMaster {
    IncomeDto execute(IncomeDto incomeDto);
}
