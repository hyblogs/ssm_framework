package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: PageRedirectController
 * @Description: 页面跳转控制器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 15:42
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
@Controller
public class PageRedirectController {

    /**
     * 前台后台登录页面
     * @return 后台登录页URL
     */
    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "/view/back/login";
    }

    /**
     * 前往后台主页
     * @return 后台主页URL
     */
    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String toIndex() {
        return "/view/back/index";
    }
}
