package com.xpenses.transaction.dto.request;

import com.xpenses.transaction.dto.request.income.IncomeReq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApiRequest<T extends IncomeReq> {
    @NotBlank(message = "Client must not be blank.")
    private String client;
    @Valid
    private T requestBody;
}
