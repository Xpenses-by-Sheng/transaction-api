package com.xpenses.transaction.common;

import com.xpenses.transaction.dto.ExpensesDto;
import com.xpenses.transaction.dto.IncomeDTO;
import lombok.Data;

@Data
public class WorkBean {
    private IncomeDTO requestIncome;
    private ExpensesDto requestExpenses;
    private IncomeDTO responseIncome;
    private ExpensesDto responseExpenses;
}
