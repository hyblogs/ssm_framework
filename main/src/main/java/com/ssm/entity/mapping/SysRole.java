package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 模块编号
     */
    @Column(name = "module_no")
    private Integer moduleNo;

    /**
     * 角色状态：0-无效；1-有效
     */
    @Column(name = "role_status")
    private Integer roleStatus;

    /**
     * 角色描述
     */
    private String remark;

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
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
     * 获取角色状态：0-无效；1-有效
     *
     * @return role_status - 角色状态：0-无效；1-有效
     */
    public Integer getRoleStatus() {
        return roleStatus;
    }

    /**
     * 设置角色状态：0-无效；1-有效
     *
     * @param roleStatus 角色状态：0-无效；1-有效
     */
    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * 获取角色描述
     *
     * @return remark - 角色描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置角色描述
     *
     * @param remark 角色描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
}