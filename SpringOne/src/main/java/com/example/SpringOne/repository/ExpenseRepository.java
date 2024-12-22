package com.example.SpringOne.repository;

import com.example.SpringOne.entity.Expense;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExpenseRepository {

    private final JdbcTemplate jdbcTemplate;

    public ExpenseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final RowMapper<Expense> expenseRowMapper = (rs, rowNum) -> {
        Expense expense = new Expense();
        expense.setId(rs.getLong("payment_id"));
        expense.setAmount(rs.getDouble("amount"));
        expense.setType(rs.getString("payment_type"));
        expense.setDate(rs.getDate("payment_date").toLocalDate());
        expense.setPurpose(rs.getString("purpose"));
        expense.setPaymentMode(rs.getString("payment_mode"));
        return expense;
    };

    public List<Expense> findAll() {
        String sql = "SELECT * FROM expense";
        return jdbcTemplate.query(sql, expenseRowMapper);
    }

    public Optional<Expense> findById(Long id) {
        String sql = "SELECT * FROM expense WHERE payment_id = ?";
        List<Expense> expenses = jdbcTemplate.query(sql, expenseRowMapper, id);
        return expenses.isEmpty() ? Optional.empty() : Optional.of(expenses.get(0));
    }

    public int save(Expense expense) {
        String sql;
        if (expense.getId() == null) {
            sql = "INSERT INTO expense (amount, payment_type, payment_date, purpose, payment_mode) VALUES (?, ?, ?, ?, ?)";
            return jdbcTemplate.update(sql, expense.getAmount(), expense.getType(), expense.getDate(), expense.getPurpose(), expense.getPaymentMode());
        } else {
            sql = "UPDATE expense SET amount = ?, payment_type = ?, payment_date = ?, purpose = ?, payment_mode = ? WHERE payment_id = ?";
            return jdbcTemplate.update(sql, expense.getAmount(), expense.getType(), expense.getDate(), expense.getPurpose(), expense.getPaymentMode(), expense.getId());
        }
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM expense WHERE payment_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
