package com.xpenses.transaction.dto.request;

import com.xpenses.transaction.dto.ExpensesDto;
import com.xpenses.transaction.dto.IncomeDto;
import lombok.Data;

@Data
public class RequestBody {
    private IncomeDto income;
    private ExpensesDto expenses;
}
