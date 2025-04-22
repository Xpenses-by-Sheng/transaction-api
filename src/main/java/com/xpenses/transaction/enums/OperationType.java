package com.xpenses.transaction.enums;

public enum OperationType {
    CREATE,
    READ,
    UPDATE,
    DELETE;

    public static OperationType getOperationType(String opType) {
        for (OperationType operation : OperationType.values())
            if (operation.name().equals(opType))
                return operation;
        return null;
    }
}
