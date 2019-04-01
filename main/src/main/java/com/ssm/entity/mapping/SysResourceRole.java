package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource_role")
public class SysResourceRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 管理员角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 系统资源ID
     */
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * 关联时间
     */
    @Column(name = "link_time")
    private Date linkTime;

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
     * 获取管理员角色ID
     *
     * @return role_id - 管理员角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置管理员角色ID
     *
     * @param roleId 管理员角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取系统资源ID
     *
     * @return resource_id - 系统资源ID
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * 设置系统资源ID
     *
     * @param resourceId 系统资源ID
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 获取关联时间
     *
     * @return link_time - 关联时间
     */
    public Date getLinkTime() {
        return linkTime;
    }

    /**
     * 设置关联时间
     *
     * @param linkTime 关联时间
     */
    public void setLinkTime(Date linkTime) {
        this.linkTime = linkTime;
    }
}