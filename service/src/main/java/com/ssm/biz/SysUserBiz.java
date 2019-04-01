package com.ssm.biz;

import com.hykit.exceptionutils.ApplicationException;
import com.ssm.entity.mapping.SysUser;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysUserBiz
 * @Description: 后台管理员账户管理业务处理接口
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-24 16:00
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-24   hy              v1.0.0             Is Create!
 */
public interface SysUserBiz {

    /**
     * 根据查询条件查询匹配的后台管理账户信息
     * @param sysUser 后台管理员用户ID
     * @return SysUsers
     * @throws ApplicationException 异常
     */
    List<SysUser> getSysUserList(SysUser sysUser) throws ApplicationException;
}
