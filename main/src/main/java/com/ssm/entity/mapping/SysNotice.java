package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_notice")
public class SysNotice implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公告标题
     */
    @Column(name = "notice_title")
    private String noticeTitle;

    /**
     * 公告内容
     */
    @Column(name = "notice_content")
    private String noticeContent;

    /**
     * 公告状态
     */
    @Column(name = "notice_state")
    private Integer noticeState;

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
     * 备注
     */
    private String remark;

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
     * 获取公告标题
     *
     * @return notice_title - 公告标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 设置公告标题
     *
     * @param noticeTitle 公告标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * 获取公告内容
     *
     * @return notice_content - 公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 设置公告内容
     *
     * @param noticeContent 公告内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    /**
     * 获取公告状态
     *
     * @return notice_state - 公告状态
     */
    public Integer getNoticeState() {
        return noticeState;
    }

    /**
     * 设置公告状态
     *
     * @param noticeState 公告状态
     */
    public void setNoticeState(Integer noticeState) {
        this.noticeState = noticeState;
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