package com.ssm.entity.mapping;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_module")
public class SysModule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模块名称
     */
    @Column(name = "module_name")
    private String moduleName;

    /**
     * 模块描述
     */
    @Column(name = "module_desc")
    private String moduleDesc;

    /**
     * 模块状态：0-无效；1-有效
     */
    @Column(name = "module_status")
    private Integer moduleStatus;

    /**
     * 模块地址
     */
    @Column(name = "module_url")
    private String moduleUrl;

    /**
     * 模块图标
     */
    @Column(name = "module_icon")
    private String moduleIcon;

    /**
     * 模块编号
     */
    @Column(name = "module_no")
    private String moduleNo;

    /**
     * 备注
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
     * 获取模块名称
     *
     * @return module_name - 模块名称
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置模块名称
     *
     * @param moduleName 模块名称
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * 获取模块描述
     *
     * @return module_desc - 模块描述
     */
    public String getModuleDesc() {
        return moduleDesc;
    }

    /**
     * 设置模块描述
     *
     * @param moduleDesc 模块描述
     */
    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    /**
     * 获取模块状态：0-无效；1-有效
     *
     * @return module_status - 模块状态：0-无效；1-有效
     */
    public Integer getModuleStatus() {
        return moduleStatus;
    }

    /**
     * 设置模块状态：0-无效；1-有效
     *
     * @param moduleStatus 模块状态：0-无效；1-有效
     */
    public void setModuleStatus(Integer moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    /**
     * 获取模块地址
     *
     * @return module_url - 模块地址
     */
    public String getModuleUrl() {
        return moduleUrl;
    }

    /**
     * 设置模块地址
     *
     * @param moduleUrl 模块地址
     */
    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    /**
     * 获取模块图标
     *
     * @return module_icon - 模块图标
     */
    public String getModuleIcon() {
        return moduleIcon;
    }

    /**
     * 设置模块图标
     *
     * @param moduleIcon 模块图标
     */
    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon;
    }

    /**
     * 获取模块编号
     *
     * @return module_no - 模块编号
     */
    public String getModuleNo() {
        return moduleNo;
    }

    /**
     * 设置模块编号
     *
     * @param moduleNo 模块编号
     */
    public void setModuleNo(String moduleNo) {
        this.moduleNo = moduleNo;
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