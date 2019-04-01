package com.ssm.entity.common;

/**
 * @author HY
 * @desc: 排序枚举类
 */
public enum OrderByEnum {
    /**
     * 状态-有效
     */
    SORT_ASC			    ("ASC","升序排列"),
    /**
     * 状态-无效
     */
    SORT_DESC			    ("DESC","降序排列");

    /**
     * 排序码：ASC/DESC
     */
    private String sortCode;
    /**
     * 排序码描述
     */
    private String sortDesc;

    OrderByEnum(String sortCode, String sortDesc) {
        this.sortCode = sortCode;
        this.sortDesc = sortDesc;
    }

    /**
     * 获取 排序码：ASCDESC
     *
     * @return sortCode 排序码：ASCDESC
     */
    public String getSortCode() {
        return this.sortCode;
    }

    /**
     * 设置 排序码：ASCDESC
     *
     * @param sortCode 排序码：ASCDESC
     */
    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    /**
     * 获取 排序码描述
     *
     * @return sortDesc 排序码描述
     */
    public String getSortDesc() {
        return this.sortDesc;
    }

    /**
     * 设置 排序码描述
     *
     * @param sortDesc 排序码描述
     */
    public void setSortDesc(String sortDesc) {
        this.sortDesc = sortDesc;
    }
}
