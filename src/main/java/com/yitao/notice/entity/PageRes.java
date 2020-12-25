package com.yitao.notice.entity;

import java.util.List;

/**
 *  分页返回类
 */
public class PageRes<T> {

    // pageNumber(当前页),pageSize(每页记录数),code(0),status(状态码默认是200),hint,Total(总记录数),rows(每页的数据)

    /**
     *  当前页
     */
    private int pageNumber;

    /**
     * 每页记录数
     */
    private int pageSize=4;

    /**
     *  总页数
     */
    private int pageCount;

    /**
     *
     */
   /* private Integer count;
    private String msg;*/
    private Integer code;
    /**
     * 规定数据状态的字段名称，默认：code
     */
    private Integer status;
    /**
     * 规定状态信息的字段名称，默认：msg
     */
    private String hint;
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 数据列表
     */
    private List<T> rows;

    public PageRes() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageRes{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", code=" + code +
                ", status=" + status +
                ", hint='" + hint + '\'' +
                ", total=" + total +
                ", rows=" + rows +
                '}';
    }
}







