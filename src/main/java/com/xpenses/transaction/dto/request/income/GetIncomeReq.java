package com.xpenses.transaction.dto.request.income;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetIncomeReq implements IncomeReq {
    private String incomeId;
    private String category;
    private String dtRegist;
}
