package org.example.service;

import org.example.pojo.Expense;
import org.example.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface ExpenseService {
    // Add an expense
    void add(Expense expense);

    // Get pages of expenses with date conditions
    PageBean<Expense> list(Integer pageNum, Integer pageSize, Integer categoryId,
                           LocalDateTime startDate, LocalDateTime endDate);
}
