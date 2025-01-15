package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.mapper.ExpenseMapper;
import org.example.pojo.Expense;
import org.example.pojo.PageBean;
import org.example.service.CategoryService;
import org.example.service.ExpenseService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseMapper expenseMapper;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void add(Expense expense) {
        // Complete necessary parameters
        expense.setCreateTime(LocalDateTime.now());
        expense.setUpdateTime(LocalDateTime.now());
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        expense.setCreateUser(userId);

        expenseMapper.add(expense);
    }

    @Override
    public PageBean<Expense> list(Integer pageNum, Integer pageSize, Integer categoryId, LocalDateTime startDate, LocalDateTime endDate) {
        // Create PageBean instance
        PageBean<Expense> pb = new PageBean<>();

        // Enable the plugin PageHelper
        PageHelper.startPage(pageNum, pageSize);

        // Call mapper method
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer userId = (Integer) claims.get("id");
        List<Expense> es = expenseMapper.list(userId, categoryId, startDate, endDate);
        Page<Expense> p = (Page<Expense>) es;

        // Inject data to the PageBean instance
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());

        return pb;
    }
}
