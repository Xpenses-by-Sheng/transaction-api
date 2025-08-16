package com.xpenses.transaction.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class IncomeDto extends BaseDto {
    private String incomeId;
}
