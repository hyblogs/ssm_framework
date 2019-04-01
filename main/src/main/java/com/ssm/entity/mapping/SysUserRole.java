package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 管理员用户ID
     */
    @Column(name = "sys_user_id")
    private Long sysUserId;

    /**
     * 管理员角色ID
     */
    @Column(name = "sys_role_id")
    private Long sysRoleId;

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
     * 获取管理员用户ID
     *
     * @return sys_user_id - 管理员用户ID
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置管理员用户ID
     *
     * @param sysUserId 管理员用户ID
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取管理员角色ID
     *
     * @return sys_role_id - 管理员角色ID
     */
    public Long getSysRoleId() {
        return sysRoleId;
    }

    /**
     * 设置管理员角色ID
     *
     * @param sysRoleId 管理员角色ID
     */
    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
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