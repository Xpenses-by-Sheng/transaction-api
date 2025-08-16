package com.xpenses.transaction.dto;

import com.xpenses.transaction.enums.OperationType;
import lombok.Data;

@Data
public class ParamsBean {
    private OperationType operationType;
}
