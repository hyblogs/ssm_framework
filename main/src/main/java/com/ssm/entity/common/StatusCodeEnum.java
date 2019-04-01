package com.ssm.entity.common;

/**
 * 枚举编码
 * @author HY
 */
public enum StatusCodeEnum {
    /**
     * 状态-有效
     */
    STATE_SUCCESS			(1,"状态有效"),
    /**
     * 状态-无效
     */
    STATE_FAILED			(0,"状态无效"),
    /**
     * 状态-已删除
     */
    STATE_DELETE            (2,"已删除");

    /**
     * 编码
     */
    private int code;

    /**
     * 编码描述
     */
    private String value;

    /**
     * 枚举构造函数
     * @param code 返回码
     * @param value 返回码描述
     */
    StatusCodeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * 获取 编码
     *
     * @return code 编码
     */
    public int getCode() {
        return this.code;
    }

    /**
     * 获取 编码描述
     *
     * @return value 编码描述
     */
    public String getValue() {
        return this.value;
    }
}
