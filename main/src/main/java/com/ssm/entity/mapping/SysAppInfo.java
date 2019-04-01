package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_app_info")
public class SysAppInfo implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统名称
     */
    @Column(name = "sys_name")
    private String sysName;

    /**
     * 系统名称简称
     */
    @Column(name = "sys_name_short")
    private String sysNameShort;

    /**
     * 系统编码
     */
    @Column(name = "sys_code")
    private String sysCode;

    /**
     * 系统Logo
     */
    @Column(name = "sys_logo")
    private String sysLogo;

    /**
     * 系统备案信息
     */
    @Column(name = "sys_records")
    private String sysRecords;

    /**
     * 系统后台地址
     */
    @Column(name = "sys_back_url")
    private String sysBackUrl;

    /**
     * 系统前台地址
     */
    @Column(name = "sys_site_url")
    private String sysSiteUrl;

    /**
     * 状态：0-无效；1-有效
     */
    private Integer state;

    /**
     * 版本号
     */
    @Column(name = "sys_version")
    private String sysVersion;

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
     * 系统简介
     */
    @Column(name = "sys_desc")
    private String sysDesc;

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
     * 获取系统名称
     *
     * @return sys_name - 系统名称
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * 设置系统名称
     *
     * @param sysName 系统名称
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * 获取系统名称简称
     *
     * @return sys_name_short - 系统名称简称
     */
    public String getSysNameShort() {
        return sysNameShort;
    }

    /**
     * 设置系统名称简称
     *
     * @param sysNameShort 系统名称简称
     */
    public void setSysNameShort(String sysNameShort) {
        this.sysNameShort = sysNameShort;
    }

    /**
     * 获取系统编码
     *
     * @return sys_code - 系统编码
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * 设置系统编码
     *
     * @param sysCode 系统编码
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * 获取系统Logo
     *
     * @return sys_logo - 系统Logo
     */
    public String getSysLogo() {
        return sysLogo;
    }

    /**
     * 设置系统Logo
     *
     * @param sysLogo 系统Logo
     */
    public void setSysLogo(String sysLogo) {
        this.sysLogo = sysLogo;
    }

    /**
     * 获取系统备案信息
     *
     * @return sys_records - 系统备案信息
     */
    public String getSysRecords() {
        return sysRecords;
    }

    /**
     * 设置系统备案信息
     *
     * @param sysRecords 系统备案信息
     */
    public void setSysRecords(String sysRecords) {
        this.sysRecords = sysRecords;
    }

    /**
     * 获取系统后台地址
     *
     * @return sys_back_url - 系统后台地址
     */
    public String getSysBackUrl() {
        return sysBackUrl;
    }

    /**
     * 设置系统后台地址
     *
     * @param sysBackUrl 系统后台地址
     */
    public void setSysBackUrl(String sysBackUrl) {
        this.sysBackUrl = sysBackUrl;
    }

    /**
     * 获取系统前台地址
     *
     * @return sys_site_url - 系统前台地址
     */
    public String getSysSiteUrl() {
        return sysSiteUrl;
    }

    /**
     * 设置系统前台地址
     *
     * @param sysSiteUrl 系统前台地址
     */
    public void setSysSiteUrl(String sysSiteUrl) {
        this.sysSiteUrl = sysSiteUrl;
    }

    /**
     * 获取状态：0-无效；1-有效
     *
     * @return state - 状态：0-无效；1-有效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态：0-无效；1-有效
     *
     * @param state 状态：0-无效；1-有效
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取版本号
     *
     * @return sys_version - 版本号
     */
    public String getSysVersion() {
        return sysVersion;
    }

    /**
     * 设置版本号
     *
     * @param sysVersion 版本号
     */
    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
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
     * 获取系统简介
     *
     * @return sys_desc - 系统简介
     */
    public String getSysDesc() {
        return sysDesc;
    }

    /**
     * 设置系统简介
     *
     * @param sysDesc 系统简介
     */
    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }
}