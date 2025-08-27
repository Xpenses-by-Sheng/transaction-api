package com.xpenses.transaction.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BaseDto {
    private String title;
    private String description;
    private int amount;
    private String currency;
    private String category;
    private String source;
    private LocalDate dtRegist;
    private LocalDateTime dtInsert;
    private LocalDateTime dtUpdate;
}
