package com.xpenses.transaction.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {
    private String title;
    private String description;
    private int amount;
    private String currency;
    private String category;
    private String source;
    private Date dtInsert;
    private Date dtUpdate;
}
