package com.xpenses.transaction.dto.request.income;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeleteIncomeReq implements IncomeReq {
    @NotBlank(message = "Income ID must not be blank.")
    private String incomeId;
}
