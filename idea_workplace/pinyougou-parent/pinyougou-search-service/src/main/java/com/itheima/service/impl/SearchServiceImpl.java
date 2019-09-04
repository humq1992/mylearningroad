package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.pojo.TbItem;
import com.itheima.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map search(Map searchMap) {
        //关键字空格处理
        String keywords = (String) searchMap.get("keywords");
        searchMap.put("keywords", keywords.replace(" ", ""));
        //创建一个hashmap
        Map map = new HashMap();
        //创建一个query对象
       /* SimpleQuery query = new SimpleQuery();
        //根据solr域创建一个条件对象
        //根据searchMap中传递的value来确定条件执行查询
        if(searchMap!=null&&searchMap.get("keywords")!=null){
            Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
            query.addCriteria(criteria);
        }else {
        query=new SimpleQuery("*:*");}

        //获得查询page对象
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query,TbItem.class);
        //返回map对象page.getContent()可以获得List<TbItem>
        map.put("rows",page.getContent());*/
       //调用私有方法


        //1查询列表
        map.putAll(searchList(searchMap));

        //2根据关键词查询分类
        List<String> categoryList = searchCategoryList(searchMap);
        map.put("categoryList",categoryList);
        //3查询品牌和规格列表
        //当选择了catagory时候则不用默认第一个分类来显示
        String category= (String) searchMap.get("category");
        if(!category.equals("")){
            map.putAll(searchBrandAndSpecList(category));
        }else {//当无选择分类时候默认使用分类列表第一个来展示；
            if(categoryList.size()>0){
                map.putAll(searchBrandAndSpecList(categoryList.get(0)));
            }
        }

        return map;

    }

    @Override
    public void importList(List list) {
            solrTemplate.saveBeans(list);
            solrTemplate.commit();
    }

    //写私有方法完成高亮功能
    private Map searchList(Map searchMap){
        Map map=new HashMap();
        HighlightQuery highlightQuery=new SimpleHighlightQuery();
        HighlightOptions highlightOptions=new HighlightOptions().addField("item_title");//设置高亮的域
        highlightOptions.setSimplePrefix("<em style='color:red'>");
        highlightOptions.setSimplePostfix("</en>");
        highlightQuery.setHighlightOptions(highlightOptions);
        //1.1设置完毕后按照关键词查询
      Criteria criteria=  new Criteria("item_keywords").is(searchMap.get("keywords"));
      highlightQuery.addCriteria(criteria);
      //1.2按照商品分类查询 过滤查询语句需要添加条件criteria 之后在加入到高亮query中
        if(!"".equals(searchMap.get("category"))  )	{//如果用户选择了分类
            FilterQuery filterQuery=new SimpleFilterQuery();
            Criteria filterCriteria=new Criteria("item_category").is(searchMap.get("category"));
            filterQuery.addCriteria(filterCriteria);
            highlightQuery.addFilterQuery(filterQuery);
        }
        //1.3按照品牌过滤
        if(!"".equals(searchMap.get("brand"))  )	{//如果用户选择了品牌
            FilterQuery filterQuery=new SimpleFilterQuery();
            Criteria filterCriteria=new Criteria("item_brand").is(searchMap.get("brand"));
            filterQuery.addCriteria(filterCriteria);
            highlightQuery.addFilterQuery(filterQuery);
        }
        //1.4按照规格过滤
        if(searchMap.get("spec")!=null){
            Map<String,String> specMap= (Map<String, String>) searchMap.get("spec");
            for(String key :specMap.keySet()){

                FilterQuery filterQuery=new SimpleFilterQuery();
                Criteria filterCriteria=new Criteria("item_spec_"+key).is( specMap.get(key)  );
                filterQuery.addCriteria(filterCriteria);
                highlightQuery.addFilterQuery(filterQuery);

            }

        }
        //1.5按照价格来赛选
        if(!"".equals(searchMap.get("price"))){
            String[] price=((String) searchMap.get("price")).split("-");
            if(!price[0].equals("0")){//如果区间起点不等于 0
                Criteria filterCriteria=new
                        Criteria("item_price").greaterThanEqual(price[0]);
                FilterQuery filterQuery=new SimpleFilterQuery(filterCriteria);
                highlightQuery.addFilterQuery(filterQuery);
            }
            if(!price[1].equals("*")){//如果区间终点不等于*
                Criteria filterCriteria=new
                        Criteria("item_price").lessThanEqual(price[1]);
                FilterQuery filterQuery=new SimpleFilterQuery(filterCriteria);
                highlightQuery.addFilterQuery(filterQuery);
            }
        }
        //1.6分页查询
        Integer pageNo= (Integer) searchMap.get("pageNo");//提取页码
        if(pageNo==null){
            pageNo=1;//默认第一页
        }
        Integer pageSize=(Integer) searchMap.get("pageSize");//每页记录数
        if(pageSize==null){
            pageSize=20;//默认 20
        }
        highlightQuery.setOffset((pageNo-1)*pageSize);//从第几条记录查询
        highlightQuery.setRows(pageSize);
        //1.7按照价格排序
        String sortValue= (String) searchMap.get("sort");//ASC  DESC
        String sortField= (String) searchMap.get("sortField");//排序字段
        if(sortValue!=null && !sortValue.equals("")){
            if(sortValue.equals("ASC")){
                Sort sort=new Sort(Sort.Direction.ASC, "item_"+sortField);
                highlightQuery.addSort(sort);
            }
            if(sortValue.equals("DESC")){
                Sort sort=new Sort(Sort.Direction.DESC, "item_"+sortField);
                highlightQuery.addSort(sort);
            }
        }
        //***********  获取高亮结果集  ***********
        //高亮页对象
        HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(highlightQuery, TbItem.class);
        for (HighlightEntry<TbItem> entry : page.getHighlighted()) {//循环遍历高亮入口
            TbItem item = entry.getEntity(); //此处查出来的是原本的实体类 并不是高亮后加入了前后缀的类
            if(entry.getHighlights().size()>0&&entry.getHighlights().get(0).getSnipplets().size()>0){
                item.setTitle(entry.getHighlights().get(0).getSnipplets().get(0));
                //                    高亮列        第一个     高亮行        第一个
            }

        }
        map.put("rows",page.getContent());
        map.put("totalPages", page.getTotalPages());//返回总页数
        map.put("total", page.getTotalElements());//返回总记录数
        return map;
    }

    /**
     *
     * 查询分类列表
     *
     */
    private List searchCategoryList(Map searchMap){
        List<String> list=new ArrayList<>();
        Query query=new SimpleQuery();
        //设置分组选项
        GroupOptions options = new GroupOptions();
        options.addGroupByField("item_category");//域名可能不只有一个，所以在获取时候还需要通过域名获得
        //设置查询关键字
      Criteria criteria=  new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        query.setGroupOptions(options);
        GroupPage<TbItem> page = solrTemplate.queryForGroupPage(query, TbItem.class);
        //获得分组结果集
        GroupResult<TbItem> groupResult = page.getGroupResult("item_category");//通过域名获得分组结果集合
        Page<GroupEntry<TbItem>> groupEntries = groupResult.getGroupEntries();//获得入口对象
        List<GroupEntry<TbItem>> content = groupEntries.getContent();//获得入口集合
        for (GroupEntry<TbItem> entry : content) {
            list.add(entry.getGroupValue());//将分组结果加入到list中
        }
        return list;
    }
    /**
     *
     * 查询品牌和规格列表
     * 用分类名称来获取品牌列表和规格列表
     */
    private Map searchBrandAndSpecList(String category){
        Map map=new HashMap();
        Long typeId = (Long) redisTemplate.boundHashOps("itemCat").get(category);
        if (typeId!=null){
            //根据模板id查询品牌列表
            List brandList = (List) redisTemplate.boundHashOps("brandList").get(typeId);
            map.put("brandList",brandList);
            List specList = (List) redisTemplate.boundHashOps("specList").get(typeId);
            map.put("specList",specList);
        }
        return map;

    }

    @Override
    public void deleteByGoodsIds(List goodsIdList) {
        System.out.println("删除商品 ID"+goodsIdList);
        Query query=new SimpleQuery();
        Criteria criteria=new Criteria("item_goodsid").in(goodsIdList);
        query.addCriteria(criteria);
        solrTemplate.delete(query);
        solrTemplate.commit();
    }



}
