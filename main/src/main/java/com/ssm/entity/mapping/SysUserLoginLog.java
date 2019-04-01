package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_login_log")
public class SysUserLoginLog implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统用户id
     */
    @Column(name = "sys_user_id")
    private Long sysUserId;

    /**
     * 登录ip
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登录时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 登录令牌
     */
    @Column(name = "login_token")
    private String loginToken;

    /**
     * 令牌状态：0-无效；1-有效
     */
    @Column(name = "token_state")
    private Integer tokenState;

    /**
     * 是否登录成功：0-登录失败；1-登录成功
     */
    @Column(name = "is_success")
    private Integer isSuccess;

    /**
     * 登录失败原因
     */
    @Column(name = "fail_remark")
    private String failRemark;

    /**
     * 操作描述
     */
    private String operation;

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
     * 获取系统用户id
     *
     * @return sys_user_id - 系统用户id
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置系统用户id
     *
     * @param sysUserId 系统用户id
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取登录ip
     *
     * @return login_ip - 登录ip
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置登录ip
     *
     * @param loginIp 登录ip
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取登录时间
     *
     * @return login_time - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取登录令牌
     *
     * @return login_token - 登录令牌
     */
    public String getLoginToken() {
        return loginToken;
    }

    /**
     * 设置登录令牌
     *
     * @param loginToken 登录令牌
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    /**
     * 获取令牌状态：0-无效；1-有效
     *
     * @return token_state - 令牌状态：0-无效；1-有效
     */
    public Integer getTokenState() {
        return tokenState;
    }

    /**
     * 设置令牌状态：0-无效；1-有效
     *
     * @param tokenState 令牌状态：0-无效；1-有效
     */
    public void setTokenState(Integer tokenState) {
        this.tokenState = tokenState;
    }

    /**
     * 获取是否登录成功：0-登录失败；1-登录成功
     *
     * @return is_success - 是否登录成功：0-登录失败；1-登录成功
     */
    public Integer getIsSuccess() {
        return isSuccess;
    }

    /**
     * 设置是否登录成功：0-登录失败；1-登录成功
     *
     * @param isSuccess 是否登录成功：0-登录失败；1-登录成功
     */
    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * 获取登录失败原因
     *
     * @return fail_remark - 登录失败原因
     */
    public String getFailRemark() {
        return failRemark;
    }

    /**
     * 设置登录失败原因
     *
     * @param failRemark 登录失败原因
     */
    public void setFailRemark(String failRemark) {
        this.failRemark = failRemark;
    }

    /**
     * 获取操作描述
     *
     * @return operation - 操作描述
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置操作描述
     *
     * @param operation 操作描述
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}