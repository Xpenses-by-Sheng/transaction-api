package com.xpenses.transaction.dto.request.income;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PutIncomeReq implements IncomeReq {
    @NotBlank(message = "Income title must not be blank.")
    private String title;
    private String description;
    @Min(value = 0, message = "Amount must be more than 0.")
    private int amount;
    @NotBlank(message = "Income currency must not be blank.")
    private String currency;
    @NotBlank(message = "Income category must not be blank.")
    private String category;
    @NotBlank(message = "Income source must not be blank.")
    private String source;
    @NotBlank(message = "Income registration date must not be blank.")
    private String dtRegist;
}
