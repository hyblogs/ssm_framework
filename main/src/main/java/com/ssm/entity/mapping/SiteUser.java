package com.ssm.entity.mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "site_user")
public class SiteUser implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户性别：0-女；1-男
     */
    private Integer sex;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户身份证号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 用户银行卡号
     */
    @Column(name = "card_number")
    private String cardNumber;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 用户住址
     */
    private String address;

    /**
     * 用户信息审核状态：0-未审核；1-审核成功；2-审核失败
     */
    @Column(name = "audit_state")
    private Integer auditState;

    /**
     * 用户信息审核时间
     */
    @Column(name = "audit_time")
    private Date auditTime;

    /**
     * 是否登录状态：0-非登录状态；1-登录状态
     */
    @Column(name = "is_login")
    private Integer isLogin;

    /**
     * 是否启用登录状态检测：0-否；1-是
     */
    @Column(name = "is_open_login_check")
    private Integer isOpenLoginCheck;

    /**
     * 账户状态：0-无效；1-有效
     */
    private Integer state;

    /**
     * 出生年
     */
    @Column(name = "birth_year")
    private Integer birthYear;

    /**
     * 登录密码状态：0-锁定；1-正常
     */
    @Column(name = "password_state")
    private Integer passwordState;

    /**
     * 登录密码锁定过期时间
     */
    @Column(name = "password_lock_expire_time")
    private Date passwordLockExpireTime;

    /**
     * 用户头像
     */
    @Column(name = "user_img")
    private String userImg;

    /**
     * 用户等级
     */
    @Column(name = "user_grade")
    private Integer userGrade;

    /**
     * 金币数量
     */
    @Column(name = "gold_count")
    private Long goldCount;

    /**
     * QQ号码
     */
    @Column(name = "qq_number")
    private String qqNumber;

    /**
     * 微信号码
     */
    @Column(name = "we_chat_number")
    private String weChatNumber;

    /**
     * 微博账户
     */
    @Column(name = "web_number")
    private String webNumber;

    /**
     * 是否公开资料：0-否；1-是
     */
    @Column(name = "is_open")
    private Integer isOpen;

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
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户昵称
     *
     * @return nick_name - 用户昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置用户昵称
     *
     * @param nickName 用户昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取用户密码
     *
     * @return password - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取用户性别：0-女；1-男
     *
     * @return sex - 用户性别：0-女；1-男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置用户性别：0-女；1-男
     *
     * @param sex 用户性别：0-女；1-男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取用户年龄
     *
     * @return age - 用户年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置用户年龄
     *
     * @param age 用户年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取用户身份证号码
     *
     * @return id_number - 用户身份证号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置用户身份证号码
     *
     * @param idNumber 用户身份证号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取用户银行卡号
     *
     * @return card_number - 用户银行卡号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 设置用户银行卡号
     *
     * @param cardNumber 用户银行卡号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户住址
     *
     * @return address - 用户住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置用户住址
     *
     * @param address 用户住址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取用户信息审核状态：0-未审核；1-审核成功；2-审核失败
     *
     * @return audit_state - 用户信息审核状态：0-未审核；1-审核成功；2-审核失败
     */
    public Integer getAuditState() {
        return auditState;
    }

    /**
     * 设置用户信息审核状态：0-未审核；1-审核成功；2-审核失败
     *
     * @param auditState 用户信息审核状态：0-未审核；1-审核成功；2-审核失败
     */
    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    /**
     * 获取用户信息审核时间
     *
     * @return audit_time - 用户信息审核时间
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 设置用户信息审核时间
     *
     * @param auditTime 用户信息审核时间
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 获取是否登录状态：0-非登录状态；1-登录状态
     *
     * @return is_login - 是否登录状态：0-非登录状态；1-登录状态
     */
    public Integer getIsLogin() {
        return isLogin;
    }

    /**
     * 设置是否登录状态：0-非登录状态；1-登录状态
     *
     * @param isLogin 是否登录状态：0-非登录状态；1-登录状态
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
     * 获取账户状态：0-无效；1-有效
     *
     * @return state - 账户状态：0-无效；1-有效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置账户状态：0-无效；1-有效
     *
     * @param state 账户状态：0-无效；1-有效
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取出生年
     *
     * @return birth_year - 出生年
     */
    public Integer getBirthYear() {
        return birthYear;
    }

    /**
     * 设置出生年
     *
     * @param birthYear 出生年
     */
    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * 获取登录密码状态：0-锁定；1-正常
     *
     * @return password_state - 登录密码状态：0-锁定；1-正常
     */
    public Integer getPasswordState() {
        return passwordState;
    }

    /**
     * 设置登录密码状态：0-锁定；1-正常
     *
     * @param passwordState 登录密码状态：0-锁定；1-正常
     */
    public void setPasswordState(Integer passwordState) {
        this.passwordState = passwordState;
    }

    /**
     * 获取登录密码锁定过期时间
     *
     * @return password_lock_expire_time - 登录密码锁定过期时间
     */
    public Date getPasswordLockExpireTime() {
        return passwordLockExpireTime;
    }

    /**
     * 设置登录密码锁定过期时间
     *
     * @param passwordLockExpireTime 登录密码锁定过期时间
     */
    public void setPasswordLockExpireTime(Date passwordLockExpireTime) {
        this.passwordLockExpireTime = passwordLockExpireTime;
    }

    /**
     * 获取用户头像
     *
     * @return user_img - 用户头像
     */
    public String getUserImg() {
        return userImg;
    }

    /**
     * 设置用户头像
     *
     * @param userImg 用户头像
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    /**
     * 获取用户等级
     *
     * @return user_grade - 用户等级
     */
    public Integer getUserGrade() {
        return userGrade;
    }

    /**
     * 设置用户等级
     *
     * @param userGrade 用户等级
     */
    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    /**
     * 获取金币数量
     *
     * @return gold_count - 金币数量
     */
    public Long getGoldCount() {
        return goldCount;
    }

    /**
     * 设置金币数量
     *
     * @param goldCount 金币数量
     */
    public void setGoldCount(Long goldCount) {
        this.goldCount = goldCount;
    }

    /**
     * 获取QQ号码
     *
     * @return qq_number - QQ号码
     */
    public String getQqNumber() {
        return qqNumber;
    }

    /**
     * 设置QQ号码
     *
     * @param qqNumber QQ号码
     */
    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    /**
     * 获取微信号码
     *
     * @return we_chat_number - 微信号码
     */
    public String getWeChatNumber() {
        return weChatNumber;
    }

    /**
     * 设置微信号码
     *
     * @param weChatNumber 微信号码
     */
    public void setWeChatNumber(String weChatNumber) {
        this.weChatNumber = weChatNumber;
    }

    /**
     * 获取微博账户
     *
     * @return web_number - 微博账户
     */
    public String getWebNumber() {
        return webNumber;
    }

    /**
     * 设置微博账户
     *
     * @param webNumber 微博账户
     */
    public void setWebNumber(String webNumber) {
        this.webNumber = webNumber;
    }

    /**
     * 获取是否公开资料：0-否；1-是
     *
     * @return is_open - 是否公开资料：0-否；1-是
     */
    public Integer getIsOpen() {
        return isOpen;
    }

    /**
     * 设置是否公开资料：0-否；1-是
     *
     * @param isOpen 是否公开资料：0-否；1-是
     */
    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
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