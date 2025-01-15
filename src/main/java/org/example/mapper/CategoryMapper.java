package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    // Add new expense category
    @Insert("INSERT INTO category(category_name, create_user, create_time, update_time) " +
    "values('${categoryName}', '${createUser}', '${createTime}', '${updateTime}')")
    void add(Category category);

    // Get a list of all categories
    @Select("SELECT * FROM category WHERE create_user = '${userId}'")
    List<Category> list(Integer userId);

    // Get category details by id
    @Select("SELECT * FROM category WHERE id = '${id}'")
    Category findById(Integer id);

    // Update category
    @Update("UPDATE category SET category_name = #{categoryName}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Category category);

    @Delete("DELETE FROM category WHERE id=#{id}")
    void deleteById(Integer id);
}
