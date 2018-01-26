package com.xiaohei.domain;

import java.util.List;

/* 封装miniui中分页显示的结果集 */
public class BaseResult<T> {

    /* 总记录数 */
    private int total;

    /* 当前页数据集合 */
    private List<T> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
