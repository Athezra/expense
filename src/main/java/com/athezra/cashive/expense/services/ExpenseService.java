package com.athezra.cashive.expense.services;

import com.athezra.cashive.expense.entities.Expense;
import com.athezra.cashive.expense.model.ExpenseModel;
import com.athezra.cashive.expense.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(ExpenseModel expenseModel)
    {
        Expense expenseEntity = new Expense();
        expenseEntity.setDescription(expenseModel.getDescription());
        expenseEntity.setExpenseDateOccurred(expenseModel.getExpenseDateOccurred());
        expenseEntity.setAmount(expenseModel.getAmount());
        expenseEntity.setType(expenseModel.getType());
        expenseEntity.setExpenseDateCreated(new Date());
        expenseEntity.setExpenseDateLastUpdated(new Date());

        return expenseRepository.save(expenseEntity);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public List<ExpenseModel> getAllExpense() {
        return expenseRepository.findAll().stream().map(expense -> {
           ExpenseModel model = new ExpenseModel();
           model.setId(expense.getId());
           model.setDescription(expense.getDescription());
           model.setAmount(expense.getAmount());
           model.setExpenseDateOccurred(expense.getExpenseDateOccurred());
           model.setType(expense.getType());
           return model;
        }).collect(Collectors.toList());
    }
}
