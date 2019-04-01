package com.ssm.controller;

import com.hykit.common.ResponseTip;
import com.hykit.common.ResultTip;
import com.hykit.logutils.LogHelper;
import com.ssm.entity.common.ResultEnum;
import com.ssm.entity.mapping.SysResource;
import com.ssm.entity.mapping.SysUser;
import com.ssm.service.SysResourceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: IndexController
 * @Description: 后台首页控制器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 17:03
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
@RestController
@RequestMapping(value = "/ssm_framework/back/")
public class IndexController {

    @Resource
    private SysResourceService sysResourceService;

    /**
     * 获取后台菜单资源
     * @return 后台菜单资源
     */
    @GetMapping(value = "getResources")
    @ResponseBody()
    public ResponseEntity<ResultTip> getResources() {
        //获取当前登录账户信息
        SysUser sysUser = new SysUser();
        //TODO 测试
        sysUser.setId(1L);
        //根据当前登录账户获取对应权限的后台菜单资源信息
        ResultTip resultTip = this.sysResourceService.getSysResource(sysUser.getId());
        LogHelper.logResponse(resultTip);
        //初始化http头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>(resultTip, headers, HttpStatus.OK);
    }
}
