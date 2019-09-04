package com.itheima.service;

import java.util.List;
import java.util.Map;

import com.itheima.PageResult;
import com.itheima.pojo.TbBrand;

public interface BrandService {
	public List<TbBrand> findAll();
	public PageResult findPage(int pageNum,int pageSize);
	public void save(TbBrand tbBrand);
	public void update(TbBrand tbBrand);
	public TbBrand findone( long id);
	public void dele(String[] ids);
	public PageResult searchPage(TbBrand tbBrand,int pageNum,int pageSize);
	public List<Map> selectOptionList();
}
