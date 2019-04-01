package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource")
public class SysResource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源名称
     */
    @Column(name = "resource_name")
    private String resourceName;

    /**
     * 模块编号
     */
    @Column(name = "module_no")
    private Integer moduleNo;

    /**
     * 父资源ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 资源层级(根目录：0，其他资源目录类推)
     */
    @Column(name = "resource_level")
    private Integer resourceLevel;

    /**
     * 资源描述
     */
    @Column(name = "resource_desc")
    private String resourceDesc;

    /**
     * 排序序号
     */
    @Column(name = "resource_sort")
    private Integer resourceSort;

    /**
     * 状态：0-无效；1-有效
     */
    @Column(name = "resource_status")
    private Integer resourceStatus;

    /**
     * 资源路径
     */
    @Column(name = "resource_url")
    private String resourceUrl;

    /**
     * 资源图标
     */
    @Column(name = "resource_icon")
    private String resourceIcon;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源名称
     *
     * @return resource_name - 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置资源名称
     *
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * 获取模块编号
     *
     * @return module_no - 模块编号
     */
    public Integer getModuleNo() {
        return moduleNo;
    }

    /**
     * 设置模块编号
     *
     * @param moduleNo 模块编号
     */
    public void setModuleNo(Integer moduleNo) {
        this.moduleNo = moduleNo;
    }

    /**
     * 获取父资源ID
     *
     * @return parent_id - 父资源ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父资源ID
     *
     * @param parentId 父资源ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取资源层级(根目录：0，其他资源目录类推)
     *
     * @return resource_level - 资源层级(根目录：0，其他资源目录类推)
     */
    public Integer getResourceLevel() {
        return resourceLevel;
    }

    /**
     * 设置资源层级(根目录：0，其他资源目录类推)
     *
     * @param resourceLevel 资源层级(根目录：0，其他资源目录类推)
     */
    public void setResourceLevel(Integer resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    /**
     * 获取资源描述
     *
     * @return resource_desc - 资源描述
     */
    public String getResourceDesc() {
        return resourceDesc;
    }

    /**
     * 设置资源描述
     *
     * @param resourceDesc 资源描述
     */
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    /**
     * 获取排序序号
     *
     * @return resource_sort - 排序序号
     */
    public Integer getResourceSort() {
        return resourceSort;
    }

    /**
     * 设置排序序号
     *
     * @param resourceSort 排序序号
     */
    public void setResourceSort(Integer resourceSort) {
        this.resourceSort = resourceSort;
    }

    /**
     * 获取状态：0-无效；1-有效
     *
     * @return resource_status - 状态：0-无效；1-有效
     */
    public Integer getResourceStatus() {
        return resourceStatus;
    }

    /**
     * 设置状态：0-无效；1-有效
     *
     * @param resourceStatus 状态：0-无效；1-有效
     */
    public void setResourceStatus(Integer resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    /**
     * 获取资源路径
     *
     * @return resource_url - 资源路径
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 设置资源路径
     *
     * @param resourceUrl 资源路径
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * 获取资源图标
     *
     * @return resource_icon - 资源图标
     */
    public String getResourceIcon() {
        return resourceIcon;
    }

    /**
     * 设置资源图标
     *
     * @param resourceIcon 资源图标
     */
    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}