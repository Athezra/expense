package com.athezra.cashive.expense.controllers;

import com.athezra.cashive.expense.model.ExpenseModel;
import com.athezra.cashive.expense.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping("/all")
    public ResponseEntity<List<ExpenseModel>> getAllExpense() {
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    @PostMapping("/save")
    public ResponseEntity<ExpenseModel> saveExpense(@RequestBody ExpenseModel expense) {
        return ResponseEntity.ok(expenseService.saveExpense(expense));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
