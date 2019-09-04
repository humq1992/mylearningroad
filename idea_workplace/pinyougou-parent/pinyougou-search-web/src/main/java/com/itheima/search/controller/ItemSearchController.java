package com.itheima.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.search.service.SearchService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/itemSearch")
public class ItemSearchController {

    @Reference
    private SearchService searchService;
    @RequestMapping("/search")
    public Map<String, Object>  searchItem(@RequestBody(required = false) Map searchMap){//此处参数需要从页面接受json数据 所以需要写@RequestBody
       if(searchMap==null || searchMap.size()==0){
           System.out.println("111111111");
       }else{
           System.out.println("22222222222");
           System.out.println(searchMap);
       }

        Map resultMap = searchService.search(searchMap);
        return resultMap;

    }
}
