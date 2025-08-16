package com.xpenses.transaction.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseDto {
    private String title;
    private String description;
    private int amount;
    private String currency;
    private String category;
    private String source;
    private Timestamp dtRegist;
    private Timestamp dtInsert;
    private Timestamp dtUpdate;
}
