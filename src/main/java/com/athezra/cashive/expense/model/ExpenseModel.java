package com.athezra.cashive.expense.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ExpenseModel {

    private String description;

    private Integer amount;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date expenseDateOccurred;

    private String type;
}
