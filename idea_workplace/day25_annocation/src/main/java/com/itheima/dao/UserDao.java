package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public interface UserDao {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id",property = "accounts",many = @Many(select = "com.itheima.dao.AccountDao",fetchType = FetchType.LAZY))
    })
    List<User> findAll();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
   @Select("select * from user where id=#{userId}")
    User findById(Integer userId);


}
