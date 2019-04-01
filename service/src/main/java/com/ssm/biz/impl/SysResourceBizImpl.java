package com.ssm.biz.impl;

import com.github.pagehelper.PageHelper;
import com.hykit.common.ResultTip;
import com.hykit.exceptionutils.ApplicationException;
import com.hykit.logutils.LogHelper;
import com.hykit.objectutils.ObjectKit;
import com.hykit.objectutils.ReflectKit;
import com.ssm.biz.SysResourceBiz;
import com.ssm.entity.common.OrderByEnum;
import com.ssm.entity.common.PageBean;
import com.ssm.entity.common.ResultEnum;
import com.ssm.entity.common.StatusCodeEnum;
import com.ssm.entity.mapping.SysResource;
import com.ssm.entity.model.SysResourceModel;
import com.ssm.mapper.SysResourceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysResourceBizImpl
 * @Description: 后台系统资源业务操作接口实现类
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 17:16
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
@Service
public class SysResourceBizImpl implements SysResourceBiz {

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResourceModel> getSysResource(Long userId) throws ApplicationException {
        try {
            //初始化返回对象
            List<SysResourceModel> sysResourceModelList = new ArrayList<>();
            //初始化查询条件Map
            Map<String, Object> params = new HashMap<>(16);
            params.put("userId", userId);
            //获取一级栏目信息
            params.put("parentId", 0L);
            params.put("resourceStatus", StatusCodeEnum.STATE_SUCCESS.getCode());
            //获取当前账户权限对应到后台父级菜单目录资源
            List<SysResource> sysResourceParentList = this.sysResourceMapper.getSysResourceByUserId(params);
            if (sysResourceParentList != null && !sysResourceParentList.isEmpty()) {
                for (SysResource sysResource : sysResourceParentList) {
                    SysResourceModel sysResourceModel = new SysResourceModel();
                    sysResourceModel.setId(sysResource.getId());
                    sysResourceModel.setResourceName(sysResource.getResourceName());
                    sysResourceModel.setResourceIcon(sysResource.getResourceIcon());
                    sysResourceModel.setResourceSort(sysResource.getResourceSort());
                    sysResourceModel.setResourceStatus(sysResource.getResourceStatus());
                    sysResourceModel.setParentId(sysResource.getParentId());
                    sysResourceModel.setResourceUrl(sysResource.getResourceUrl());
                    sysResourceModel.setResourceLevel(sysResource.getResourceLevel());
                    //获取二级栏目信息
                    params.put("parentId", sysResource.getId());
                    List<SysResource> sysResourceSonList = this.sysResourceMapper.getSysResourceByUserId(params);
                    sysResourceModel.setSysResourceList(sysResourceSonList);
                    //组织栏目信息加入集合
                    sysResourceModelList.add(sysResourceModel);
                }
            }
            return sysResourceModelList;
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    public List<SysResource> getSysResourceByPage(SysResource sysResource, PageBean pageBean) throws ApplicationException {
        try {
            //设置分页
            PageHelper.startPage(pageBean.getCurrentPage(), pageBean.getPageSize());
            ReflectKit.nullifyStrings(pageBean);
            //记录日志
            LogHelper.print(sysResource);
            //排序信息Map
            Map<String, Object> orderByMap = new HashMap<>(16);
            orderByMap.put("sortColumn", "sys_resource.resource_sort");
            orderByMap.put("sort", OrderByEnum.SORT_ASC.getSortCode());
            //执行查询
            return this.sysResourceMapper.getSysResourceList(ObjectKit.makeQueryMapOverlookStatic(sysResource, orderByMap, true));
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }
    
    @Override
    public Integer saveSysResource(SysResource sysResource) throws ApplicationException {
        try {
            if (sysResource == null) {
                //抛出异常
                ResultTip resultTip = new ResultTip(ResultEnum.NULL_POINTER_ERROR.getCode(), ResultEnum.NULL_POINTER_ERROR.getValue());
                throw new ApplicationException(resultTip);
            }
            //设置创建时间
            sysResource.setCreateTime(new Date());
            //记录日志
            LogHelper.print(String.valueOf(sysResource.getId()), sysResource);
            //执行持久化操作
            return this.sysResourceMapper.insertSelective(sysResource);
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    public Integer delSysResource(Long sysResourceId) throws ApplicationException {
        try {
            //记录日志
            LogHelper.print(String.valueOf(sysResourceId), sysResourceId);
            //执行持久化操作
            return this.sysResourceMapper.deleteByPrimaryKey(sysResourceId);
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    public Integer editSysResource(SysResource sysResource) throws ApplicationException {
        try {
            if (sysResource == null) {
                //参数异常，抛出异常
                ResultTip resultTip = new ResultTip(ResultEnum.NULL_POINTER_ERROR.getCode(), ResultEnum.NULL_POINTER_ERROR.getValue());
                throw new ApplicationException(resultTip);
            }
            //设置修改时间
            sysResource.setUpdateTime(new Date());
            //记录日志
            LogHelper.print(String.valueOf(sysResource.getId()), sysResource);
            //执行持久化操作
            return this.sysResourceMapper.updateByPrimaryKeySelective(sysResource);
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }

    @Override
    public List<SysResource> getSysResourceList(SysResource sysResource, Integer type) throws ApplicationException {
        try {
            //筛选条件
            Map<String, Object> params = new HashMap<>(2);
            params.clear();
            if (type != null) {
                params.put("type", type);
            }
            //记录日志
            LogHelper.print(sysResource);
            //执行查询
            return this.sysResourceMapper.getSysResourceList(ObjectKit.makeQueryMapOverlookStatic(sysResource, params, true));
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }
}
