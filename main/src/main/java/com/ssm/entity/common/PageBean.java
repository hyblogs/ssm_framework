package com.ssm.entity.common;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: PageBean
 * @Description: 分页信息实体
 * @version: v1.0.0
 * @author: HY
 * @date: 2018-07-21 23:20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-07-21   HY              v1.0.0             修改原因
 */
@SuppressWarnings("serial")
public class PageBean<T> implements Serializable {

    /** 当前页 */
    private Integer currentPage = 1;
    /** 每页显示的总条数 */
    private Integer pageSize = 10;
    /** 总条数 */
    private Integer totalNum;
    /** 是否有下一页 */
    private Integer isNext;
    /** 总页数 */
    private Integer totalPage;
    /** 开始索引 */
    private Integer startIndex;
    /** 分页结果 */
    private List<T> items;

    public PageBean() {
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalNum=" + totalNum +
                ", isNext=" + isNext +
                ", totalPage=" + totalPage +
                ", startIndex=" + startIndex +
                ", items=" + items +
                '}';
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum, Integer isNext, Integer totalPage, Integer startIndex, List<T> items) {

        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.isNext = isNext;
        this.totalPage = totalPage;
        this.startIndex = startIndex;
        this.items = items;
    }

    /**
     * 获取 当前页
     *
     * @return currentPage 当前页
     */
    public Integer getCurrentPage() {
        return this.currentPage;
    }

    /**
     * 设置 当前页
     *
     * @param currentPage 当前页
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 获取 每页显示的总条数
     *
     * @return pageSize 每页显示的总条数
     */
    public Integer getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置 每页显示的总条数
     *
     * @param pageSize 每页显示的总条数
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 总条数
     *
     * @return totalNum 总条数
     */
    public Integer getTotalNum() {
        return this.totalNum;
    }

    /**
     * 设置 总条数
     *
     * @param totalNum 总条数
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 获取 是否有下一页
     *
     * @return isNext 是否有下一页
     */
    public Integer getIsNext() {
        return this.isNext;
    }

    /**
     * 设置 是否有下一页
     *
     * @param isNext 是否有下一页
     */
    public void setIsNext(Integer isNext) {
        this.isNext = isNext;
    }

    /**
     * 获取 总页数
     *
     * @return totalPage 总页数
     */
    public Integer getTotalPage() {
        return this.totalPage;
    }

    /**
     * 设置 总页数
     *
     * @param totalPage 总页数
     */
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取 开始索引
     *
     * @return startIndex 开始索引
     */
    public Integer getStartIndex() {
        return this.startIndex;
    }

    /**
     * 设置 开始索引
     *
     * @param startIndex 开始索引
     */
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 获取 分页结果
     *
     * @return items 分页结果
     */
    public List<T> getItems() {
        return this.items;
    }

    /**
     * 设置 分页结果
     *
     * @param items 分页结果
     */
    public void setItems(List<T> items) {
        this.items = items;
    }
}
