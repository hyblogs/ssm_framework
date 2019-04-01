package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_catalog_info")
public class SysCatalogInfo implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 目录菜单名称
     */
    @Column(name = "catalog_name")
    private String catalogName;

    /**
     * 目录菜单编号
     */
    @Column(name = "catalog_code")
    private String catalogCode;

    /**
     * 状态：0-无效；1-有效
     */
    @Column(name = "catalog_state")
    private Integer catalogState;

    /**
     * 目录菜单图标
     */
    @Column(name = "catalog_icon")
    private String catalogIcon;

    /**
     * 目录菜单链接地址
     */
    @Column(name = "catalog_url")
    private String catalogUrl;

    /**
     * 目录菜单颜色(十六进制)
     */
    @Column(name = "catalog_color")
    private String catalogColor;

    /**
     * 目录菜单序号
     */
    @Column(name = "catalog_sort")
    private Integer catalogSort;

    /**
     * 类型：0-头部；1-底部
     */
    @Column(name = "catalog_type")
    private Integer catalogType;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取目录菜单名称
     *
     * @return catalog_name - 目录菜单名称
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置目录菜单名称
     *
     * @param catalogName 目录菜单名称
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    /**
     * 获取目录菜单编号
     *
     * @return catalog_code - 目录菜单编号
     */
    public String getCatalogCode() {
        return catalogCode;
    }

    /**
     * 设置目录菜单编号
     *
     * @param catalogCode 目录菜单编号
     */
    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    /**
     * 获取状态：0-无效；1-有效
     *
     * @return catalog_state - 状态：0-无效；1-有效
     */
    public Integer getCatalogState() {
        return catalogState;
    }

    /**
     * 设置状态：0-无效；1-有效
     *
     * @param catalogState 状态：0-无效；1-有效
     */
    public void setCatalogState(Integer catalogState) {
        this.catalogState = catalogState;
    }

    /**
     * 获取目录菜单图标
     *
     * @return catalog_icon - 目录菜单图标
     */
    public String getCatalogIcon() {
        return catalogIcon;
    }

    /**
     * 设置目录菜单图标
     *
     * @param catalogIcon 目录菜单图标
     */
    public void setCatalogIcon(String catalogIcon) {
        this.catalogIcon = catalogIcon;
    }

    /**
     * 获取目录菜单链接地址
     *
     * @return catalog_url - 目录菜单链接地址
     */
    public String getCatalogUrl() {
        return catalogUrl;
    }

    /**
     * 设置目录菜单链接地址
     *
     * @param catalogUrl 目录菜单链接地址
     */
    public void setCatalogUrl(String catalogUrl) {
        this.catalogUrl = catalogUrl;
    }

    /**
     * 获取目录菜单颜色(十六进制)
     *
     * @return catalog_color - 目录菜单颜色(十六进制)
     */
    public String getCatalogColor() {
        return catalogColor;
    }

    /**
     * 设置目录菜单颜色(十六进制)
     *
     * @param catalogColor 目录菜单颜色(十六进制)
     */
    public void setCatalogColor(String catalogColor) {
        this.catalogColor = catalogColor;
    }

    /**
     * 获取目录菜单序号
     *
     * @return catalog_sort - 目录菜单序号
     */
    public Integer getCatalogSort() {
        return catalogSort;
    }

    /**
     * 设置目录菜单序号
     *
     * @param catalogSort 目录菜单序号
     */
    public void setCatalogSort(Integer catalogSort) {
        this.catalogSort = catalogSort;
    }

    /**
     * 获取类型：0-头部；1-底部
     *
     * @return catalog_type - 类型：0-头部；1-底部
     */
    public Integer getCatalogType() {
        return catalogType;
    }

    /**
     * 设置类型：0-头部；1-底部
     *
     * @param catalogType 类型：0-头部；1-底部
     */
    public void setCatalogType(Integer catalogType) {
        this.catalogType = catalogType;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}