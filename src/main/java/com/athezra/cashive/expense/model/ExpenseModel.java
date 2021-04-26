package com.athezra.cashive.expense.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ExpenseModel {

    private Long id;

    private String description;

    private Float amount;

    @JsonFormat(pattern="yyyy/MM/dd")
    private Date expenseDateOccurred;

    private String type;
}
