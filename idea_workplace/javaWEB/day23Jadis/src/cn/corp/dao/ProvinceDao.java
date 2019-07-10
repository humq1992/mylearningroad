package cn.corp.dao;

import cn.corp.domain.Province;

import java.util.List;

public interface ProvinceDao {
    public List<Province> findall();
    public void add(String s);
}
