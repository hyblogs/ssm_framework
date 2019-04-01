package com.ssm.service;

import com.hykit.common.ResultTip;
import com.ssm.entity.common.PageBean;
import com.ssm.entity.mapping.SysResource;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysResourceService
 * @Description: 后台系统资源业务操作服务接口
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 17:18
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
public interface SysResourceService {

    /**
     * 根据后台管理员账户ID获取对应的后台菜单资源信息
     * @param userId 后台管理员账户ID
     * @return 后台菜单资源信息
     */
    ResultTip getSysResource(Long userId);

    /**
     * 分页查询栏目信息列表
     *
     * @param sysResource 查询条件对象
     * @param pageBean    分页条件对象
     * @return 后台菜单资源信息集合
     */
    ResultTip getSysResourceByPage(SysResource sysResource, PageBean pageBean);

    /**
     * 新增菜单信息
     * @param sysResource 系统资源信息
     * @return 数据受影响行数
     */
    ResultTip saveSysResource(SysResource sysResource);

    /**
     * 删除菜单信息
     * @param sysResourceId 要删除的菜单Id
     * @return 数据受影响行数
     */
    ResultTip delSysResource(Long sysResourceId);

    /**
     * 修改菜单信息
     * @param sysResource 要修改的菜单信息
     * @return 数据受影响行数
     */
    ResultTip editSysResource(SysResource sysResource);

    /**
     * 根据条件获取菜单信息列表
     *
     * @param sysResource 查询条件
     * @param type        查询类型
     * @return 数据受影响行数
     */
    ResultTip getSysResourceList(SysResource sysResource, Integer type);
}
