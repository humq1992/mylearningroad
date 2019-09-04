package com.itheima.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.PageResult;
import com.itheima.SaveResult;
import com.itheima.pojo.TbBrand;
import com.itheima.service.BrandService;

import javassist.expr.NewArray;

@RestController
@RequestMapping("/brand")
public class BrandController {
	@Reference(timeout = 5000)
	private BrandService brandService;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		List<TbBrand> findAll = brandService.findAll();
		return findAll;
	}

	@RequestMapping("/findPage")
	public PageResult findPage(int pageNum, int pageSize) {
		PageResult pageResult = brandService.findPage(pageNum, pageSize);
		return pageResult;
	}

	@RequestMapping("/save")
	public SaveResult save(@RequestBody TbBrand tbBrand) {
		try {
			brandService.save(tbBrand);
			return new SaveResult("新增成功", true);
		} catch (Exception e) {
			// TODO: handle exception
			return new SaveResult("新增失败", false);
		}
	}

	@RequestMapping("/findone")
	public TbBrand findone(long id) {
		TbBrand tBrand = brandService.findone(id);
		return tBrand;
	}

	@RequestMapping("/update")
	public SaveResult update(@RequestBody TbBrand tbBrand) {
		try {
			brandService.update(tbBrand);
			return new SaveResult("修改成功", true);
		} catch (Exception e) {
			// TODO: handle exception
			return new SaveResult("修改失败", false);
		}
	}

	@RequestMapping("/dele")
	public void dele(String[] ids) {
		brandService.dele(ids);
	}

	@RequestMapping("/searchPage")
	public PageResult searchPage(@RequestBody TbBrand tbBrand, int pageNum, int pageSize) {
		PageResult pageResult = brandService.searchPage(tbBrand, pageNum, pageSize);
		return pageResult;

	}
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		List<Map> maps=	brandService.selectOptionList();
		return maps;
	}
}
