package com.itheima.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.TbSpecificationMapper;
import com.itheima.mapper.TbSpecificationOptionMapper;
import com.itheima.pojo.TbSpecification;
import com.itheima.pojo.TbSpecificationExample;
import com.itheima.pojo.TbSpecificationExample.Criteria;
import com.itheima.pojo.TbSpecificationOption;
import com.itheima.pojo.TbSpecificationOptionExample;
import com.itheima.pojogroup.Specification;
import com.itheima.service.SpecificationService;

import com.itheima.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;
	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		specificationMapper.insert(specification.getSpecification());		
		for(TbSpecificationOption specificationOption:specification.getTbSpecificationOptionList()) {
			specificationOptionMapper.insert(specificationOption);
		}
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		//再修改其中的集合时候 需要先删除上一次的内容 再进行添加 不然无法改变集合内数目 而实际功能中 是可以为同一个模板 添加或者减少规格参数的；
		
		specificationMapper.updateByPrimaryKey(specification.getSpecification());	
		//因为现在输入的为新输入的规格，所以无法获得旧的规格的参数  只有通过获得模板的id来确定specId来完成删除；
		TbSpecificationOptionExample example = new	TbSpecificationOptionExample();
		com.itheima.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(specification.getSpecification().getId());
		specificationOptionMapper.deleteByExample(example);
		//然后再循环加入新的规格
		for(TbSpecificationOption specificationOption:specification.getTbSpecificationOptionList()) {
			specificationOptionMapper.insert(specificationOption);
		}
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		
		TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		com.itheima.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(tbSpecification.getId());
		List<TbSpecificationOption> example2 = specificationOptionMapper.selectByExample(example);
		Specification specification = new Specification();
		specification.setSpecification(tbSpecification);
		specification.setTbSpecificationOptionList(example2);
		return specification;
		
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			com.itheima.pojo.TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			specificationOptionMapper.deleteByExample(example);
			
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

		@Override
		public List<Map> selectOptionList() {
			
			List<Map> selectOptionList = specificationMapper.selectOptionList();
			return selectOptionList;
					
			
		}
	
}
