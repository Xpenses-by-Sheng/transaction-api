package com.xpenses.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "EXPENSES_MASTER")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
