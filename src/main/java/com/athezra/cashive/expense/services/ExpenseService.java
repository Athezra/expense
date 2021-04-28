package com.athezra.cashive.expense.services;

import com.athezra.cashive.expense.entities.Expense;
import com.athezra.cashive.expense.model.ExpenseModel;
import com.athezra.cashive.expense.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseModel saveExpense(ExpenseModel expenseModel)
    {
        Expense expenseEntity = new Expense();
        expenseEntity.setDescription(expenseModel.getDescription());
        expenseEntity.setExpenseDateOccurred(expenseModel.getExpenseDateOccurred());
        expenseEntity.setAmount(expenseModel.getAmount());
        expenseEntity.setType(expenseModel.getType());
        expenseEntity.setExpenseDateCreated(ZonedDateTime.now());
        expenseEntity.setExpenseDateLastUpdated(ZonedDateTime.now());

        return getExpenseModelFromEntity(expenseRepository.save(expenseEntity));
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public List<ExpenseModel> getAllExpense() {
        return expenseRepository.findAll().stream().map(this::getExpenseModelFromEntity).collect(Collectors.toList());
    }

    private ExpenseModel getExpenseModelFromEntity(Expense expense) {
        ExpenseModel model = new ExpenseModel();
        model.setId(expense.getId());
        model.setDescription(expense.getDescription());
        model.setAmount(expense.getAmount());
        model.setExpenseDateOccurred(expense.getExpenseDateOccurred());
        model.setType(expense.getType());
        return model;
    }
}
