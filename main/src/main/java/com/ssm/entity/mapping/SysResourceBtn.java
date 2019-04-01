package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource_btn")
public class SysResourceBtn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统资源ID
     */
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * 按钮ID
     */
    @Column(name = "btn_id")
    private Long btnId;

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
     * 获取按钮ID
     *
     * @return btn_id - 按钮ID
     */
    public Long getBtnId() {
        return btnId;
    }

    /**
     * 设置按钮ID
     *
     * @param btnId 按钮ID
     */
    public void setBtnId(Long btnId) {
        this.btnId = btnId;
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