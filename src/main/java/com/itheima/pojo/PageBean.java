package com.itheima.pojo;

import java.util.List;

public class PageBean<T> {
    private int totalCount; // 总记录数

    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTatalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
