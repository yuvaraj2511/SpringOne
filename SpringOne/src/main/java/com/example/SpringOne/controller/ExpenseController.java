package com.example.SpringOne.controller;

import com.example.SpringOne.entity.Expense;
import com.example.SpringOne.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
@CrossOrigin("http://localhost:3000")
public class ExpenseController {
    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id " + id));
    }

    @PostMapping("/cash-in")
    public Expense addCashInExpense(@RequestBody Expense expense) {
        expense.setType("Cash In");
        return expenseRepository.save(expense);
    }

    @PostMapping("/cash-out")
    public Expense addCashOutExpense(@RequestBody Expense expense) {
        expense.setType("Cash Out");
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
    }

    @PutMapping("/put/{id}")
    public Expense update(@RequestBody Expense updatedExpense, @PathVariable Long id) {
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id " + id));

        if (updatedExpense.getAmount() != null) {
            existingExpense.setAmount(updatedExpense.getAmount());
        }
        if (updatedExpense.getType() != null) {
            existingExpense.setType(updatedExpense.getType());
        }
        if (updatedExpense.getDate() != null) {
            existingExpense.setDate(updatedExpense.getDate());
        }
        if (updatedExpense.getPurpose() != null) {
            existingExpense.setPurpose(updatedExpense.getPurpose());
        }
        if (updatedExpense.getPaymentMode() != null) {
            existingExpense.setPaymentMode(updatedExpense.getPaymentMode());
        }

        return expenseRepository.save(existingExpense);
    }



}
