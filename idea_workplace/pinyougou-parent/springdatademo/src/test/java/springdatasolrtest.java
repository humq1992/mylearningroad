import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-solr.xml")
public class springdatasolrtest {

    @Autowired
    private SolrTemplate solrTemplate;
    @Test
    public void testadd(){
        TbItem tbItem = new TbItem();
        tbItem.setId(1l);
        tbItem.setBrand("华为");
        tbItem.setCategory("平板");
        tbItem.setGoodsId(12700l);
        tbItem.setPrice(new BigDecimal(2000.00));
        tbItem.setTitle("1折赔本赚吆喝，兜底售卖");
        solrTemplate.saveBean(tbItem);
        solrTemplate.commit();

    }
    @Test
    public void findAll(){
        ScoredPage<TbItem> tbItems = solrTemplate.queryForPage(new SimpleQuery("*:*"), TbItem.class);
        System.out.println(tbItems.getContent());
    }
    /*
    * 条件查询
    *
    * */

    @Test
    public void find(){
        SimpleQuery simpleQuery = new SimpleQuery("*:*");
        Criteria criteria1 = new Criteria("item_title").contains("2");
        criteria1.and("item_price").between(10,20000);
        simpleQuery.addCriteria(criteria1);
        //查询出来的page实际为一个ScoredPage类 里面包含内容 页码 总数 等分页的数据；
        ScoredPage<TbItem> page = solrTemplate.queryForPage(simpleQuery, TbItem.class);
        List<TbItem> content = page.getContent();
        System.out.println(content);


    }

}
