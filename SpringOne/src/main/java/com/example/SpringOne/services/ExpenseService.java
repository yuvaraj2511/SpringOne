package com.example.SpringOne.services;

import com.example.SpringOne.entity.Expense;
import com.example.SpringOne.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id " + id));
    }

    public Expense addCashInExpense(Expense expense) {
        expense.setType("Cash In");
        expenseRepository.save(expense);
        return expense;
    }

    public Expense addCashOutExpense(Expense expense) {
        expense.setType("Cash Out");
        expenseRepository.save(expense);
        return expense;
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Expense updatedExpense, Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (!optionalExpense.isPresent()) {
            throw new RuntimeException("Expense not found with id " + id);
        }

        Expense existingExpense = optionalExpense.get();

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

        expenseRepository.save(existingExpense);
        return existingExpense;
    }
}
