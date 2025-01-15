package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Expense;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ExpenseMapper {

    // Add an expense
    @Insert("INSERT INTO expense(amount, description, category_id, create_user, create_time, update_time)" +
            "values(#{amount}, #{description}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Expense expense);


    // Return pages of expenses with conditions
    List<Expense> list(Integer userId, Integer categoryId, LocalDateTime startDate, LocalDateTime endDate);
}
