package com.ssm.entity.common;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: ZTree
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: HY
 * @date: 2018-08-13 22:44
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-08-13   HY              v1.0.0             修改原因
 */
public class Ztree implements Serializable {
    /** ID */
    private Long id;
    /** 父节点ID */
    private Long pid;
    /** 节点名称 */
    private String text;
    /** 图标 */
    private String iconCls;
    /** 是否打开 */
    private Boolean open;
    /** 是否为父节点 */
    private Boolean isParent;
    /** 排序 */
    private Long sort;
    /** 链接地址 */
    private String linkUrl;
    /** 是否选中 */
    private Boolean checked;
    /** 子节点信息 */
    private List<Ztree> children;

    public Ztree() {}

    public Ztree(Long id, Long pid, String text, String iconCls) {
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.iconCls = iconCls;
    }

    public Ztree(Long id, Long pid, String text, Long sort, String linkUrl) {
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.sort = sort;
        this.linkUrl = linkUrl;
    }

    public Ztree(Long id, Long pid, String text, Boolean open, Long sort, String linkUrl) {
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.open = open;
        this.sort = sort;
        this.linkUrl = linkUrl;
    }

    public Ztree(Long id, Long pid, String text, Boolean open, Long sort, String linkUrl, Boolean checked) {
        this.id = id;
        this.pid = pid;
        this.text = text;
        this.open = open;
        this.linkUrl = linkUrl;
        this.checked = checked;
    }

    /**
     * 获取 ID
     *
     * @return id ID
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 设置 ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 父节点ID
     *
     * @return pid 父节点ID
     */
    public Long getPid() {
        return this.pid;
    }

    /**
     * 设置 父节点ID
     *
     * @param pid 父节点ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取 节点名称
     *
     * @return text 节点名称
     */
    public String getText() {
        return this.text;
    }

    /**
     * 设置 节点名称
     *
     * @param text 节点名称
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 获取 图标
     *
     * @return iconCls 图标
     */
    public String getIconCls() {
        return this.iconCls;
    }

    /**
     * 设置 图标
     *
     * @param iconCls 图标
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    /**
     * 获取 是否打开
     *
     * @return open 是否打开
     */
    public Boolean getOpen() {
        return this.open;
    }

    /**
     * 设置 是否打开
     *
     * @param open 是否打开
     */
    public void setOpen(Boolean open) {
        this.open = open;
    }

    /**
     * 获取 是否为父节点
     *
     * @return isParent 是否为父节点
     */
    public Boolean getIsParent() {
        return this.isParent;
    }

    /**
     * 设置 是否为父节点
     *
     * @param isParent 是否为父节点
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * 获取 排序
     *
     * @return sort 排序
     */
    public Long getSort() {
        return this.sort;
    }

    /**
     * 设置 排序
     *
     * @param sort 排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取 链接地址
     *
     * @return linkUrl 链接地址
     */
    public String getLinkUrl() {
        return this.linkUrl;
    }

    /**
     * 设置 链接地址
     *
     * @param linkUrl 链接地址
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 获取 是否选中
     *
     * @return checked 是否选中
     */
    public Boolean getChecked() {
        return this.checked;
    }

    /**
     * 设置 是否选中
     *
     * @param checked 是否选中
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    /**
     * 获取 子节点信息
     *
     * @return children 子节点信息
     */
    public List<Ztree> getChildren() {
        return this.children;
    }

    /**
     * 设置 子节点信息
     *
     * @param children 子节点信息
     */
    public void setChildren(List<Ztree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Ztree{" +
                "id=" + id +
                ", pid=" + pid +
                ", text='" + text + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", open=" + open +
                ", isParent=" + isParent +
                ", sort=" + sort +
                ", linkUrl='" + linkUrl + '\'' +
                ", checked=" + checked +
                ", children=" + children +
                '}';
    }
}
