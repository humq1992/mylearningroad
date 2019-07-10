package com.itheima.dao;

import com.itheima.domain.User_roleExample;
import com.itheima.domain.User_roleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User_roleMapper {
    long countByExample(User_roleExample example);

    int deleteByExample(User_roleExample example);

    int deleteByPrimaryKey(User_roleKey key);

    int insert(User_roleKey record);

    int insertSelective(User_roleKey record);

    List<User_roleKey> selectByExample(User_roleExample example);

    int updateByExampleSelective(@Param("record") User_roleKey record, @Param("example") User_roleExample example);

    int updateByExample(@Param("record") User_roleKey record, @Param("example") User_roleExample example);
}