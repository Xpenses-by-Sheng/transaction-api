package com.xpenses.transaction.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class IncomeParamsBean extends ParamsBean {
    private IncomeDto income;
}
