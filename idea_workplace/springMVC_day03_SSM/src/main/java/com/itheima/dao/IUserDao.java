package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserDao {
    @Select("select * from user")
    List<User> findall();
    @Insert("INSERT INTO user(name,age) VALUES( #{name},#{age})")
    void addUser(User user);

}
