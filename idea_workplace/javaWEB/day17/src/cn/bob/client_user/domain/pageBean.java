package cn.bob.client_user.domain;

import java.util.List;

public class pageBean<T> {
    private Integer currentpage;
    private Integer rows;
    private Integer count;
    private List<T> list;
    private Integer totalpage;

    public Integer getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(Integer currentpage) {
        this.currentpage = currentpage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }
}
