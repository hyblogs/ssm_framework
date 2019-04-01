package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.hykit.common.ResultTip;
import com.hykit.logutils.LogHelper;
import com.ssm.entity.common.PageBean;
import com.ssm.entity.mapping.SysResource;
import com.ssm.service.SysResourceService;
import com.ssm.utils.common.ControllerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysResourceController
 * @Description: 后台菜单资源信息操作控制器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 22:34
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
@RestController
@RequestMapping(value = "/ssm_framework/back/sysResource")
public class SysResourceController {

    @Resource
    private SysResourceService sysResourceService;

    /**
     * 分页查询后台菜单资源信息
     * @param sysResource 后台菜单资源信息查询条件
     * @param pageBean 分页信息
     * @return 结果
     */
    @GetMapping(value = "getSysResourceByPage")
    public ResponseEntity<ResultTip> getSysResourceByPage(SysResource sysResource, PageBean pageBean) {
        LogHelper.logRequest(new String[]{"sysResource", "pageBean"}, sysResource, pageBean);
        //Service返回数据
        ResultTip rt = this.sysResourceService.getSysResourceByPage(sysResource, pageBean);
        //处理分页
        rt.setRetObj(new PageInfo<>((List<SysResource>) rt.getRetObj()));
        return ControllerUtil.getResponseEntity(rt);
    }

    @PostMapping(value = "saveSysResource")
    public ResponseEntity<ResultTip> saveSysResource(SysResource sysResource) {
        LogHelper.logRequest(sysResource);
        //Service返回数据
        ResultTip rt = this.sysResourceService.saveSysResource(sysResource);
        return ControllerUtil.getResponseEntity(rt);
    }

    @PostMapping(value = "delSysResource")
    public ResponseEntity<ResultTip> delSysResource(Long sysResourceId) {
        LogHelper.logRequest(sysResourceId);
        //Service返回数据
        ResultTip rt = this.sysResourceService.delSysResource(sysResourceId);
        return ControllerUtil.getResponseEntity(rt);
    }

    @PostMapping(value = "editSysResource")
    public ResponseEntity<ResultTip> editSysResource(SysResource sysResource) {
        LogHelper.logRequest(sysResource);
        //Service返回数据
        ResultTip rt = this.sysResourceService.editSysResource(sysResource);
        return ControllerUtil.getResponseEntity(rt);
    }

    @GetMapping(value = "getSysResourceList")
    public ResponseEntity<ResultTip> getSysResourceList(SysResource sysResource, Integer type) {
        LogHelper.logRequest(sysResource);
        //Service返回数据
        ResultTip rt = this.sysResourceService.getSysResourceList(sysResource, type);
        return ControllerUtil.getResponseEntity(rt);
    }
}
