package com.itheima.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.itheima.pojo.TbSpecification;
import com.itheima.pojo.TbSpecificationOption;

public class Specification implements Serializable {
	private TbSpecification specification;
	private List<TbSpecificationOption> tbSpecificationOptionList;
	public TbSpecification getSpecification() {
		return specification;
	}
	public void setSpecification(TbSpecification specification) {
		this.specification = specification;
	}
	public List<TbSpecificationOption> getTbSpecificationOptionList() {
		return tbSpecificationOptionList;
	}
	public void setTbSpecificationOptionList(List<TbSpecificationOption> tbSpecificationOptionList) {
		this.tbSpecificationOptionList = tbSpecificationOptionList;
	}
	
	
	
	

}
