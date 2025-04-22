package com.xpenses.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "INCOME_MASTER")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "income_master_seq")
    @SequenceGenerator(name = "income_master_seq", sequenceName = "SEQ_INCOME_MASTER", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private int amount;
    private String currency;
    private String category;
    private String source;
    private Timestamp dtInsert;
    private Timestamp dtUpdate;
}
