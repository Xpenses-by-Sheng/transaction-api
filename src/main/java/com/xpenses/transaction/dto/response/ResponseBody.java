package com.xpenses.transaction.dto.response;

import com.xpenses.transaction.dto.ExpensesDto;
import com.xpenses.transaction.dto.IncomeDto;
import lombok.Data;

@Data
public class ResponseBody {
    private IncomeDto income;
    private ExpensesDto expenses;
}
