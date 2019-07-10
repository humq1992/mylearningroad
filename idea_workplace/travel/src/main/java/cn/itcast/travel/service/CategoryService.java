package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;

public interface CategoryService {
    public String findall();
    public PageBean findbypage(int cid, int currentpage, int pagesize, String rname);

}
