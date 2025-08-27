package com.xpenses.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "INCOME_MASTER")
public class Income {
    @Id
    @UuidGenerator
    private String incomeId;
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
