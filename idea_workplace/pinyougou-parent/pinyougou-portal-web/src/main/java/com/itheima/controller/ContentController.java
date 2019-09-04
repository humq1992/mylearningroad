package com.itheima.controller;

import com.itheima.pojo.TbContent;
import com.itheima.service.ContentService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
 @Reference
 private ContentService contentService;

@RequestMapping("/findByCategoryId")
 public List<TbContent> findByCategoryId(long categoryId){

       List<TbContent> list = contentService.findByCategoryId(categoryId);
       return list;

 }

}
