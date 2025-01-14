package org.example.controller;

import org.example.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @GetMapping("/list")
    public Result<String> list() {
        return Result.success("All expense data...");
    }
}
