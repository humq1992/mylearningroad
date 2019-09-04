package com.itheima.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.PageResult;
import com.itheima.mapper.TbBrandMapper;
import com.itheima.pojo.TbBrand;
import com.itheima.pojo.TbBrandExample;
import com.itheima.pojo.TbBrandExample.Criteria;
import com.itheima.service.BrandService;


@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private TbBrandMapper tbBrandMapper;

	@Override
	public List<TbBrand> findAll() {
		
		return tbBrandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page =(Page<TbBrand>) tbBrandMapper.selectByExample(null);
		PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
		
		return pageResult;
	}

	@Override
	public void save(TbBrand tbBrand) {
		
		tbBrandMapper.insert(tbBrand);
		
	}

	@Override
	public void update(TbBrand tbBrand) {
		
		tbBrandMapper.updateByPrimaryKey(tbBrand);
		
	}

	@Override
	public TbBrand findone(long id) {
		TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
		return tbBrand;
	}

	@Override
	public void dele(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			tbBrandMapper.deleteByPrimaryKey(Long.parseLong(ids[i]));
		}
	}

	@Override
	public PageResult searchPage(TbBrand tbBrand, int pageNum, int pageSize) {
		
		
		TbBrandExample tbBrandExample = new TbBrandExample();
		Criteria criteria = tbBrandExample.createCriteria();
		
		if(tbBrand!=null) {
		if(tbBrand.getName()!=null&&tbBrand.getName().length()>0) {
			criteria.andNameLike("%"+tbBrand.getName()+"%");
		}
		if(tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().length()>0) {
			criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
		}
		}
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page=   (Page<TbBrand>)tbBrandMapper.selectByExample(tbBrandExample);
	
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		return	tbBrandMapper.selectOptionList();
		
	}

}
