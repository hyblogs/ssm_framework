package com.ssm.biz;

import com.hykit.exceptionutils.ApplicationException;
import com.ssm.entity.common.PageBean;
import com.ssm.entity.mapping.SysResource;
import com.ssm.entity.model.SysResourceModel;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysResourceBiz
 * @Description: 后台系统资源业务操作接口
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 17:14
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
public interface SysResourceBiz {

    /**
     * 根据条件获取对应的后台菜单资源信息
     * @param userId 后台管理员账户ID
     * @return 后台菜单资源信息
     * @throws ApplicationException 异常
     */
    List<SysResourceModel> getSysResource(Long userId) throws ApplicationException;

    /**
     * 分页查询菜单信息列表
     * @param sysResource 查询条件对象
     * @param pageBean  分页条件对象
     * @return 后台菜单资源信息集合
     * @throws ApplicationException 异常
     */
    List<SysResource> getSysResourceByPage(SysResource sysResource, PageBean pageBean) throws ApplicationException;
    
    /**
     * 新增菜单信息
     * @param sysResource 系统资源信息
     * @return 数据受影响行数
     * @throws ApplicationException 异常
     */
    Integer saveSysResource(SysResource sysResource) throws ApplicationException;

    /**
     * 删除菜单信息
     * @param sysResourceId 要删除的菜单Id
     * @return 数据受影响行数
     * @throws ApplicationException 异常
     */
    Integer delSysResource(Long sysResourceId) throws ApplicationException;

    /**
     * 修改菜单信息
     * @param sysResource 要修改的菜单信息
     * @return 数据受影响行数
     * @throws ApplicationException 异常
     */
    Integer editSysResource(SysResource sysResource) throws ApplicationException;

    /**
     * 根据条件获取菜单信息列表
     * @param sysResource 查询条件
     * @param type  查询类型
     * @return 数据受影响行数
     * @throws ApplicationException 异常
     */
    List<SysResource> getSysResourceList(SysResource sysResource, Integer type) throws ApplicationException;

}
