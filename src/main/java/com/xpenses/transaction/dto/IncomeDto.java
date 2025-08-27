package com.xpenses.transaction.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class IncomeDto extends BaseDto {
    private String incomeId;
}
