package org.example.controller;

import org.example.pojo.Expense;
import org.example.pojo.Result;
import org.example.pojo.PageBean;
import org.example.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Result add(@RequestBody @Validated Expense expense) {
        expenseService.add(expense);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Expense>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String timeRange,
            @RequestParam(required = false) Integer categoryId,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endDate
    ) {
        if (timeRange != null) {
            if (timeRange.equals("last7days")) {
                startDate = LocalDateTime.now().minusDays(7);
            } else if (timeRange.equals("last30days")) {
                startDate = LocalDateTime.now().minusDays(30);
            } else if (timeRange.equals("last3months")) {
                startDate = LocalDateTime.now().minusMonths(3);
            }

            if (endDate == null) {
                endDate = LocalDateTime.now();
            }
        }

        PageBean<Expense> pb = expenseService.list(pageNum, pageSize, categoryId, startDate, endDate);
        return Result.success(pb);
    }

}
