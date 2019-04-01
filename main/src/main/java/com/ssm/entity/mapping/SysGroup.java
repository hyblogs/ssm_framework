package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_group")
public class SysGroup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 分组描述
     */
    @Column(name = "group_desc")
    private String groupDesc;

    /**
     * 分组状态：0-无效；1-有效
     */
    @Column(name = "group_status")
    private Integer groupStatus;

    /**
     * 父ID(一级分组默认父ID为0)
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 分组管理员(TODO)
     */
    @Column(name = "group_manager")
    private String groupManager;

    /**
     * 分组编号
     */
    @Column(name = "group_no")
    private String groupNo;

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
     * 描述
     */
    private String remark;

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
     * 获取分组名称
     *
     * @return group_name - 分组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置分组名称
     *
     * @param groupName 分组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取分组描述
     *
     * @return group_desc - 分组描述
     */
    public String getGroupDesc() {
        return groupDesc;
    }

    /**
     * 设置分组描述
     *
     * @param groupDesc 分组描述
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     * 获取分组状态：0-无效；1-有效
     *
     * @return group_status - 分组状态：0-无效；1-有效
     */
    public Integer getGroupStatus() {
        return groupStatus;
    }

    /**
     * 设置分组状态：0-无效；1-有效
     *
     * @param groupStatus 分组状态：0-无效；1-有效
     */
    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }

    /**
     * 获取父ID(一级分组默认父ID为0)
     *
     * @return parent_id - 父ID(一级分组默认父ID为0)
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父ID(一级分组默认父ID为0)
     *
     * @param parentId 父ID(一级分组默认父ID为0)
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取分组管理员(TODO)
     *
     * @return group_manager - 分组管理员(TODO)
     */
    public String getGroupManager() {
        return groupManager;
    }

    /**
     * 设置分组管理员(TODO)
     *
     * @param groupManager 分组管理员(TODO)
     */
    public void setGroupManager(String groupManager) {
        this.groupManager = groupManager;
    }

    /**
     * 获取分组编号
     *
     * @return group_no - 分组编号
     */
    public String getGroupNo() {
        return groupNo;
    }

    /**
     * 设置分组编号
     *
     * @param groupNo 分组编号
     */
    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
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
     * 获取描述
     *
     * @return remark - 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述
     *
     * @param remark 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}