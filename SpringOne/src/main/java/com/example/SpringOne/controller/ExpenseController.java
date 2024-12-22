package com.example.SpringOne.controller;

import com.example.SpringOne.entity.Expense;
import com.example.SpringOne.services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin("http://localhost:3000")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @PostMapping("/cash-in")
    public Expense addCashInExpense(@RequestBody Expense expense) {
        return expenseService.addCashInExpense(expense);
    }

    @PostMapping("/cash-out")
    public Expense addCashOutExpense(@RequestBody Expense expense) {
        return expenseService.addCashOutExpense(expense);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @PutMapping("/put/{id}")
    public Expense update(@RequestBody Expense updatedExpense, @PathVariable Long id) {
        return expenseService.updateExpense(updatedExpense, id);
    }
}
