package com.xpenses.transaction.dto.request.income;

import jakarta.validation.constraints.NotBlank;

public class DeleteIncomeReq implements IncomeReq {
    @NotBlank(message = "Income ID must not be blank.")
    private String incomeId;
}
