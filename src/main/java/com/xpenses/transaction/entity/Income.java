package com.xpenses.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;

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
    private Timestamp dtInsert;
    private Timestamp dtUpdate;
}
