package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@CacheNamespace(blocking = true)
public interface AccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one=@One(select = "com.itheima.dao.UserDao.findById",fetchType = FetchType.LAZY))
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountByUid(Integer uid);

}
