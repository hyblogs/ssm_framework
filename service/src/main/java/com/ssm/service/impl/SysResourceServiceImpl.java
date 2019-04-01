package com.ssm.service.impl;

import com.hykit.common.ResultTip;
import com.hykit.exceptionutils.ApplicationException;
import com.hykit.exceptionutils.FormatExceptionStack;
import com.hykit.logutils.LogHelper;
import com.ssm.biz.SysResourceBiz;
import com.ssm.entity.common.PageBean;
import com.ssm.entity.common.ResultEnum;
import com.ssm.entity.mapping.SysResource;
import com.ssm.entity.model.SysResourceModel;
import com.ssm.service.SysResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysResourceServiceImpl
 * @Description: 后台菜单资源操作服务接口实现类
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 17:20
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {

    @Resource
    private SysResourceBiz sysResourceBiz;

    @Override
    public ResultTip getSysResource(Long userId) {
        //初始化返回对象
        ResultTip resultTip = new ResultTip();
        try {
            List<SysResourceModel> sysResourceList = this.sysResourceBiz.getSysResource(userId);
            resultTip.setRetObj(sysResourceList);
            resultTip.setRetCode(ResultEnum.SUCCESS.getCode());
            resultTip.setRetMessage(ResultEnum.SUCCESS.getValue());
        } catch (Exception e) {
            LogHelper.error("根据查询条件获取对应的后台菜单资源信息出现异常", e);
            resultTip.setRetCode(ResultEnum.COMMON_EXCEPTION_ERROR.getCode());
            resultTip.setRetMessage(ResultEnum.COMMON_EXCEPTION_ERROR.getValue());
        }
        return resultTip;
    }

    @Override
    public ResultTip getSysResourceByPage(SysResource sysResource, PageBean pageBean) {
        ResultTip resultTip = new ResultTip();
        try {
            resultTip.setRetObj(this.sysResourceBiz.getSysResourceByPage(sysResource, pageBean));
            resultTip.setRetCode(ResultEnum.SUCCESS.getCode());
            resultTip.setRetMessage(ResultEnum.SUCCESS.getValue());
        } catch (Exception e) {
            LogHelper.error("分页查询后台菜单资源信息出现异常", e);
            resultTip.setRetCode(ResultEnum.COMMON_EXCEPTION_ERROR.getCode());
            resultTip.setRetMessage(ResultEnum.COMMON_EXCEPTION_ERROR.getValue());
        }
        return resultTip;
    }

    @Override
    public ResultTip saveSysResource(SysResource sysResource) {
        ResultTip resultTip = new ResultTip();
        try {
            resultTip.setRetObj(this.sysResourceBiz.saveSysResource(sysResource));
            resultTip.setRetCode(ResultEnum.SUCCESS.getCode());
            resultTip.setRetMessage(ResultEnum.SUCCESS.getValue());
        } catch(ApplicationException ae){
            LogHelper.error("保存后台菜单资源信息出现异常", ae);
            resultTip.setRetCode(ae.getErrCode());
            resultTip.setRetMessage(ae.getErrMessage());
        } catch(Exception e){
            LogHelper.error(FormatExceptionStack.formatException(e));
            resultTip.setRetCode(ResultEnum.COMMON_EXCEPTION_ERROR.getCode());
            resultTip.setRetMessage(ResultEnum.COMMON_EXCEPTION_ERROR.getValue());
        }
        return resultTip;
    }

    @Override
    public ResultTip delSysResource(Long sysResourceId) {
        ResultTip resultTip = new ResultTip();
        try {
            resultTip.setRetObj(this.sysResourceBiz.delSysResource(sysResourceId));
            resultTip.setRetCode(ResultEnum.SUCCESS.getCode());
            resultTip.setRetMessage(ResultEnum.SUCCESS.getValue());
        } catch(ApplicationException ae){
            LogHelper.error("删除后台菜单资源信息出现异常", ae);
            resultTip.setRetCode(ae.getErrCode());
            resultTip.setRetMessage(ae.getErrMessage());
        } catch(Exception e){
            LogHelper.error("删除后台菜单资源信息出现异常", FormatExceptionStack.formatException(e));
            resultTip.setRetCode(ResultEnum.COMMON_EXCEPTION_ERROR.getCode());
            resultTip.setRetMessage(ResultEnum.COMMON_EXCEPTION_ERROR.getValue());
        }
        return resultTip;
    }

    @Override
    public ResultTip editSysResource(SysResource sysResource) {
        ResultTip resultTip = new ResultTip();
        try {
            resultTip.setRetObj(this.sysResourceBiz.editSysResource(sysResource));
            resultTip.setRetCode(ResultEnum.SUCCESS.getCode());
            resultTip.setRetMessage(ResultEnum.SUCCESS.getValue());
        } catch(ApplicationException ae){
            LogHelper.error("修改后台菜单资源信息出现异常", ae);
            resultTip.setRetCode(ae.getErrCode());
            resultTip.setRetMessage(ae.getErrMessage());
        } catch(Exception e){
            LogHelper.error("修改后台菜单资源信息出现异常", FormatExceptionStack.formatException(e));
            resultTip.setRetCode(ResultEnum.COMMON_EXCEPTION_ERROR.getCode());
            resultTip.setRetMessage(ResultEnum.COMMON_EXCEPTION_ERROR.getValue());
        }
        return resultTip;
    }

    @Override
    public ResultTip getSysResourceList(SysResource sysResource, Integer type) {
        ResultTip resultTip = new ResultTip();
        try {
            resultTip.setRetObj(this.sysResourceBiz.getSysResourceList(sysResource, type));
            resultTip.setRetCode(ResultEnum.SUCCESS.getCode());
            resultTip.setRetMessage(ResultEnum.SUCCESS.getValue());
        } catch(ApplicationException ae){
            LogHelper.error("获取后台菜单资源信息出现异常", ae);
            resultTip.setRetCode(ae.getErrCode());
            resultTip.setRetMessage(ae.getErrMessage());
        } catch(Exception e){
            LogHelper.error("获取后台菜单资源信息出现异常", FormatExceptionStack.formatException(e));
            resultTip.setRetCode(ResultEnum.COMMON_EXCEPTION_ERROR.getCode());
            resultTip.setRetMessage(ResultEnum.COMMON_EXCEPTION_ERROR.getValue());
        }
        return resultTip;
    }
}
