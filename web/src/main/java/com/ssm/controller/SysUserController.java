package com.ssm.controller;

import com.ssm.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysUserController
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-24 16:07
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-24   hy              v1.0.0             Is Create!
 */
@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
}
