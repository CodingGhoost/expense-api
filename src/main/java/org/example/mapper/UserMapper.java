package org.example.mapper;

import org.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

@Mapper
public interface UserMapper {

    // Find user by username
    @Select("SELECT * FROM users WHERE username=#{username}")
    public User findByUsername(String username);

    // Add a user
    @Insert("INSERT INTO users(username, password, created_time, updated_time)" +
            " values('${username}', '${password}', now(), now())")
    public void add(String username, String password);
}
