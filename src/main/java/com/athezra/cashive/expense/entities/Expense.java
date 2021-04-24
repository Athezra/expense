package com.athezra.cashive.expense.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "exp_date_created")
    private Date expenseDateCreated;

    @Column(name = "exp_date_last_updated")
    private Date expenseDateLastUpdated;

    @Column(name = "exp_date_occured", unique = true, nullable = false)
    private Date expenseDateOccurred;

    @Column(name = "exp_description", unique = true, nullable = false)
    private String description;

    @Column(name = "exp_amount", unique = true, nullable = false)
    private Integer amount;

    @Column(name = "exp_type", unique = true, nullable = false)
    private String type;


}
