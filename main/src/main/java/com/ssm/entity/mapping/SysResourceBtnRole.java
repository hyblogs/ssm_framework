package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource_btn_role")
public class SysResourceBtnRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源按钮关联ID
     */
    @Column(name = "resource_btn_id")
    private Long resourceBtnId;

    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;

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
     * 获取资源按钮关联ID
     *
     * @return resource_btn_id - 资源按钮关联ID
     */
    public Long getResourceBtnId() {
        return resourceBtnId;
    }

    /**
     * 设置资源按钮关联ID
     *
     * @param resourceBtnId 资源按钮关联ID
     */
    public void setResourceBtnId(Long resourceBtnId) {
        this.resourceBtnId = resourceBtnId;
    }

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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