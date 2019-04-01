package com.ssm.controller;

import com.hykit.common.ResultTip;
import com.hykit.encodeutils.PasswordEncode;
import com.hykit.logutils.LogHelper;
import com.hykit.stringutils.StringUtil;
import com.ssm.entity.mapping.SysUser;
import com.ssm.entity.common.ResultEnum;
import com.ssm.entity.common.StatusCodeEnum;
import com.ssm.service.SysUserService;
import com.ssm.entity.common.Constants;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: LoginController
 * @Description: 登录控制器
 * @version: v1.0.0
 * @author: HY
 * @date: 2018-08-12 09:31
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-08-12   HY              v1.0.0             修改原因
 */
@RestController
@RequestMapping(value = "/ssm_framework/back")
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping(value = "/login")
    public ResultTip login(@RequestParam() String username, @RequestParam() String password,
                           @RequestParam String authCode, HttpSession session) {
        LogHelper.logRequest(Constants.LOG_TAG, new String[]{"username", "authCode"}, username, authCode);
        try {
            if(StringUtil.isBlank(username)) {
                LogHelper.print(String.valueOf(ResultEnum.USER_NAME_IS_EMPTY.getCode()), ResultEnum.USER_NAME_IS_EMPTY.getValue());
                return new ResultTip(ResultEnum.USER_NAME_IS_EMPTY.getCode(), ResultEnum.USER_NAME_IS_EMPTY.getValue());
            }
            if(StringUtil.isBlank(password)) {
                LogHelper.print(String.valueOf(ResultEnum.USER_PASSWORD_IS_EMPTY.getCode()), ResultEnum.USER_PASSWORD_IS_EMPTY.getValue());
                return new ResultTip(ResultEnum.USER_PASSWORD_IS_EMPTY.getCode(), ResultEnum.USER_PASSWORD_IS_EMPTY.getValue());
            }
            if (StringUtil.isBlank(authCode)) {
                LogHelper.print(String.valueOf(ResultEnum.USER_AUTHCODE_IS_EMPTY.getCode()), ResultEnum.USER_AUTHCODE_IS_EMPTY.getValue());
                return new ResultTip(ResultEnum.USER_AUTHCODE_IS_EMPTY.getCode(), ResultEnum.USER_AUTHCODE_IS_EMPTY.getValue());
            }
            //获取Session中的验证码
            String authCodeInit = String.valueOf(session.getAttribute(Constants.AUTH_CODE_SESSION_KEY));
            if (!authCode.toLowerCase().equals(authCodeInit)) {
                LogHelper.print(String.valueOf(ResultEnum.USER_AUTHCODE_IS_ERROR.getCode()), ResultEnum.USER_AUTHCODE_IS_ERROR.getValue());
                return new ResultTip(ResultEnum.USER_AUTHCODE_IS_ERROR.getCode(), ResultEnum.USER_AUTHCODE_IS_ERROR.getValue());
            }
            //根据当前登录名称查询数据库对应的管理员账户信息
            SysUser user = this.sysUserService.getSysUserByName(username);
            if(user == null) {
                LogHelper.print(String.valueOf(ResultEnum.USER_IS_NOT_EXIST.getCode()), ResultEnum.USER_IS_NOT_EXIST.getValue());
                return new ResultTip(ResultEnum.USER_IS_NOT_EXIST.getCode(), ResultEnum.USER_IS_NOT_EXIST.getValue());
            }
            if(user.getStatus() != StatusCodeEnum.STATE_SUCCESS.getCode()) {
                LogHelper.print(String.valueOf(ResultEnum.USER_IS_FORBIDDEN.getCode()), ResultEnum.USER_IS_FORBIDDEN.getValue());
                return new ResultTip(ResultEnum.USER_IS_FORBIDDEN.getCode(), ResultEnum.USER_IS_FORBIDDEN.getValue());
            }
            String salt = user.getSalt();
            password = PasswordEncode.encryptPassword(salt, password);
            if (!password.equals(user.getPassword())) {
                LogHelper.print(String.valueOf(ResultEnum.USERNAME_OR_PASSWORD_ERROR.getCode()), ResultEnum.USERNAME_OR_PASSWORD_ERROR.getValue());
                return new ResultTip(ResultEnum.USERNAME_OR_PASSWORD_ERROR.getCode(), ResultEnum.USERNAME_OR_PASSWORD_ERROR.getValue());
            }

            //不做Security校验直接登录成功
            LogHelper.print(String.valueOf(ResultEnum.LOGIN_SUCCESS.getCode()), ResultEnum.LOGIN_SUCCESS.getValue());
            return new ResultTip(ResultEnum.LOGIN_SUCCESS.getCode(), ResultEnum.LOGIN_SUCCESS.getValue());

            //TODO
            //Security校验
            /*Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            if (subject.isAuthenticated()) {
                SessionUtils.setSessionUser(user);
                session.setAttribute("LOGIN_USER", user.getSysUserName());
                LogHelper.print(String.valueOf(ResultEnum.LOGIN_SUCCESS.getCode()), ResultEnum.LOGIN_SUCCESS.getValue());
                return new ResultTip(ResultEnum.LOGIN_SUCCESS.getCode(), ResultEnum.LOGIN_SUCCESS.getValue());
            } else {
                LogHelper.print(String.valueOf(ResultEnum.USERNAME_OR_PASSWORD_ERROR.getCode()), ResultEnum.USERNAME_OR_PASSWORD_ERROR.getValue());
                return new ResultTip(ResultEnum.USERNAME_OR_PASSWORD_ERROR.getCode(), ResultEnum.USERNAME_OR_PASSWORD_ERROR.getValue());
            }*/
        } catch (AuthenticationException e){
            LogHelper.print(String.valueOf(ResultEnum.USERNAME_OR_PASSWORD_ERROR.getCode()), ResultEnum.USERNAME_OR_PASSWORD_ERROR.getValue());
            e.printStackTrace();
            return new ResultTip(ResultEnum.USERNAME_OR_PASSWORD_ERROR.getCode(), ResultEnum.USERNAME_OR_PASSWORD_ERROR.getValue());
        }
    }
}
