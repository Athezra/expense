package com.athezra.cashive.expense.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpenseModel {

    private Long id;

    private String description;

    private BigDecimal amount;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "en-IN", timezone = "Asia/Kolkata")
    private Date expenseDateOccurred;

    private String type;
}
