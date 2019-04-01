package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_btn_info")
public class SysBtnInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 按钮名称
     */
    @Column(name = "btn_name")
    private String btnName;

    /**
     * 按钮描述
     */
    @Column(name = "btn_desc")
    private String btnDesc;

    /**
     * 按钮编号
     */
    @Column(name = "btn_no")
    private String btnNo;

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
     * 是否有效：0-无效；1-有效
     */
    @Column(name = "btn_status")
    private Integer btnStatus;

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
     * 获取按钮名称
     *
     * @return btn_name - 按钮名称
     */
    public String getBtnName() {
        return btnName;
    }

    /**
     * 设置按钮名称
     *
     * @param btnName 按钮名称
     */
    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    /**
     * 获取按钮描述
     *
     * @return btn_desc - 按钮描述
     */
    public String getBtnDesc() {
        return btnDesc;
    }

    /**
     * 设置按钮描述
     *
     * @param btnDesc 按钮描述
     */
    public void setBtnDesc(String btnDesc) {
        this.btnDesc = btnDesc;
    }

    /**
     * 获取按钮编号
     *
     * @return btn_no - 按钮编号
     */
    public String getBtnNo() {
        return btnNo;
    }

    /**
     * 设置按钮编号
     *
     * @param btnNo 按钮编号
     */
    public void setBtnNo(String btnNo) {
        this.btnNo = btnNo;
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
     * 获取是否有效：0-无效；1-有效
     *
     * @return btn_status - 是否有效：0-无效；1-有效
     */
    public Integer getBtnStatus() {
        return btnStatus;
    }

    /**
     * 设置是否有效：0-无效；1-有效
     *
     * @param btnStatus 是否有效：0-无效；1-有效
     */
    public void setBtnStatus(Integer btnStatus) {
        this.btnStatus = btnStatus;
    }
}