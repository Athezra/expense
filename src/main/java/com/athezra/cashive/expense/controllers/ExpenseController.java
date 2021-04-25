package com.athezra.cashive.expense.controllers;

import com.athezra.cashive.expense.entities.Expense;
import com.athezra.cashive.expense.model.ExpenseModel;
import com.athezra.cashive.expense.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("expense/all")
    public ResponseEntity<List<ExpenseModel>> getAllExpense() {
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    @PostMapping("expense/save")
    public ResponseEntity<Expense> saveExpense(@RequestBody ExpenseModel expense) {
        return ResponseEntity.ok(expenseService.saveExpense(expense));
    }

    @DeleteMapping("expense/delete/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
