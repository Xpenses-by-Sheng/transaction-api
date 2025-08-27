package com.xpenses.transaction.dto.request.income;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateIncomeReq implements IncomeReq {
    @NotBlank(message = "Income ID must not be blank.")
    private String incomeId;
    private String title;
    private String description;
    private int amount;
    private String currency;
    private String category;
    private String source;
    private String dtRegist;
}
