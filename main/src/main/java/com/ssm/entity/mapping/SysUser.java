package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 分组ID
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别：0-女；1-男
     */
    private Integer sex;

    /**
     * 身份证号码(加密)
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 电子邮箱地址
     */
    private String email;

    /**
     * 账户状态：0-无效；1-有效
     */
    private Integer status;

    /**
     * 审核状态：0-审核失败；1-审核成功；2-未审核
     */
    @Column(name = "audit_status")
    private Integer auditStatus;

    /**
     * 审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 是否登录状态：0-非登录状态;1-登录状态
     */
    @Column(name = "is_login")
    private Integer isLogin;

    /**
     * 是否启用登录状态检测：0-否；1-是
     */
    @Column(name = "is_open_login_check")
    private Integer isOpenLoginCheck;

    /**
     * 最后登录IP地址
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 注册时间
     */
    @Column(name = "register_time")
    private Date registerTime;

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
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取分组ID
     *
     * @return group_id - 分组ID
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置分组ID
     *
     * @param groupId 分组ID
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取加密盐
     *
     * @return salt - 加密盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置加密盐
     *
     * @param salt 加密盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别：0-女；1-男
     *
     * @return sex - 性别：0-女；1-男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别：0-女；1-男
     *
     * @param sex 性别：0-女；1-男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取身份证号码(加密)
     *
     * @return id_number - 身份证号码(加密)
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置身份证号码(加密)
     *
     * @param idNumber 身份证号码(加密)
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取电子邮箱地址
     *
     * @return email - 电子邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱地址
     *
     * @param email 电子邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取账户状态：0-无效；1-有效
     *
     * @return status - 账户状态：0-无效；1-有效
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置账户状态：0-无效；1-有效
     *
     * @param status 账户状态：0-无效；1-有效
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取审核状态：0-审核失败；1-审核成功；2-未审核
     *
     * @return audit_status - 审核状态：0-审核失败；1-审核成功；2-未审核
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 设置审核状态：0-审核失败；1-审核成功；2-未审核
     *
     * @param auditStatus 审核状态：0-审核失败；1-审核成功；2-未审核
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 获取审核时间
     *
     * @return audit_time - 审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置审核时间
     *
     * @param auditTime 审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取是否登录状态：0-非登录状态;1-登录状态
     *
     * @return is_login - 是否登录状态：0-非登录状态;1-登录状态
     */
    public Integer getIsLogin() {
        return isLogin;
    }

    /**
     * 设置是否登录状态：0-非登录状态;1-登录状态
     *
     * @param isLogin 是否登录状态：0-非登录状态;1-登录状态
     */
    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    /**
     * 获取是否启用登录状态检测：0-否；1-是
     *
     * @return is_open_login_check - 是否启用登录状态检测：0-否；1-是
     */
    public Integer getIsOpenLoginCheck() {
        return isOpenLoginCheck;
    }

    /**
     * 设置是否启用登录状态检测：0-否；1-是
     *
     * @param isOpenLoginCheck 是否启用登录状态检测：0-否；1-是
     */
    public void setIsOpenLoginCheck(Integer isOpenLoginCheck) {
        this.isOpenLoginCheck = isOpenLoginCheck;
    }

    /**
     * 获取最后登录IP地址
     *
     * @return last_login_ip - 最后登录IP地址
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置最后登录IP地址
     *
     * @param lastLoginIp 最后登录IP地址
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取最后登录时间
     *
     * @return last_login_time - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取注册时间
     *
     * @return register_time - 注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     *
     * @param registerTime 注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
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