package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_news")
public class SysNews implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资讯标题
     */
    @Column(name = "news_title")
    private String newsTitle;

    /**
     * 副标题
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * 资讯内容
     */
    @Column(name = "news_content")
    private String newsContent;

    /**
     * 资讯概要
     */
    @Column(name = "news_outline")
    private String newsOutline;

    /**
     * 资讯类型(枚举变量)
     */
    @Column(name = "news_type")
    private Integer newsType;

    /**
     * 资讯状态：0-无效；1-有效
     */
    @Column(name = "news_state")
    private Integer newsState;

    /**
     * 资讯作者
     */
    @Column(name = "news_author")
    private String newsAuthor;

    /**
     * 资讯来源
     */
    @Column(name = "news_from")
    private String newsFrom;

    /**
     * 资讯来源地址
     */
    @Column(name = "news_from_url")
    private String newsFromUrl;

    /**
     * 点击查看地址
     */
    @Column(name = "link_url")
    private String linkUrl;

    /**
     * 是否外部来源：0-否；1-是
     */
    @Column(name = "is_outer")
    private Integer isOuter;

    /**
     * 资讯图片(多个用逗号隔开)
     */
    @Column(name = "news_imgs")
    private String newsImgs;

    /**
     * 阅读量
     */
    @Column(name = "red_counts")
    private Long redCounts;

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
     * 获取资讯标题
     *
     * @return news_title - 资讯标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 设置资讯标题
     *
     * @param newsTitle 资讯标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 获取副标题
     *
     * @return sub_title - 副标题
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * 设置副标题
     *
     * @param subTitle 副标题
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * 获取资讯内容
     *
     * @return news_content - 资讯内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 设置资讯内容
     *
     * @param newsContent 资讯内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    /**
     * 获取资讯概要
     *
     * @return news_outline - 资讯概要
     */
    public String getNewsOutline() {
        return newsOutline;
    }

    /**
     * 设置资讯概要
     *
     * @param newsOutline 资讯概要
     */
    public void setNewsOutline(String newsOutline) {
        this.newsOutline = newsOutline;
    }

    /**
     * 获取资讯类型(枚举变量)
     *
     * @return news_type - 资讯类型(枚举变量)
     */
    public Integer getNewsType() {
        return newsType;
    }

    /**
     * 设置资讯类型(枚举变量)
     *
     * @param newsType 资讯类型(枚举变量)
     */
    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    /**
     * 获取资讯状态：0-无效；1-有效
     *
     * @return news_state - 资讯状态：0-无效；1-有效
     */
    public Integer getNewsState() {
        return newsState;
    }

    /**
     * 设置资讯状态：0-无效；1-有效
     *
     * @param newsState 资讯状态：0-无效；1-有效
     */
    public void setNewsState(Integer newsState) {
        this.newsState = newsState;
    }

    /**
     * 获取资讯作者
     *
     * @return news_author - 资讯作者
     */
    public String getNewsAuthor() {
        return newsAuthor;
    }

    /**
     * 设置资讯作者
     *
     * @param newsAuthor 资讯作者
     */
    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    /**
     * 获取资讯来源
     *
     * @return news_from - 资讯来源
     */
    public String getNewsFrom() {
        return newsFrom;
    }

    /**
     * 设置资讯来源
     *
     * @param newsFrom 资讯来源
     */
    public void setNewsFrom(String newsFrom) {
        this.newsFrom = newsFrom;
    }

    /**
     * 获取资讯来源地址
     *
     * @return news_from_url - 资讯来源地址
     */
    public String getNewsFromUrl() {
        return newsFromUrl;
    }

    /**
     * 设置资讯来源地址
     *
     * @param newsFromUrl 资讯来源地址
     */
    public void setNewsFromUrl(String newsFromUrl) {
        this.newsFromUrl = newsFromUrl;
    }

    /**
     * 获取点击查看地址
     *
     * @return link_url - 点击查看地址
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 设置点击查看地址
     *
     * @param linkUrl 点击查看地址
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 获取是否外部来源：0-否；1-是
     *
     * @return is_outer - 是否外部来源：0-否；1-是
     */
    public Integer getIsOuter() {
        return isOuter;
    }

    /**
     * 设置是否外部来源：0-否；1-是
     *
     * @param isOuter 是否外部来源：0-否；1-是
     */
    public void setIsOuter(Integer isOuter) {
        this.isOuter = isOuter;
    }

    /**
     * 获取资讯图片(多个用逗号隔开)
     *
     * @return news_imgs - 资讯图片(多个用逗号隔开)
     */
    public String getNewsImgs() {
        return newsImgs;
    }

    /**
     * 设置资讯图片(多个用逗号隔开)
     *
     * @param newsImgs 资讯图片(多个用逗号隔开)
     */
    public void setNewsImgs(String newsImgs) {
        this.newsImgs = newsImgs;
    }

    /**
     * 获取阅读量
     *
     * @return red_counts - 阅读量
     */
    public Long getRedCounts() {
        return redCounts;
    }

    /**
     * 设置阅读量
     *
     * @param redCounts 阅读量
     */
    public void setRedCounts(Long redCounts) {
        this.redCounts = redCounts;
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