package com.ssm.service;

import com.ssm.entity.mapping.SysUser;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysUserService
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-24 16:02
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-24   hy              v1.0.0             Is Create!
 */
public interface SysUserService {

    /**
     * 根据账户名查询对应的后台管理员账户信息
     * @param userName 账户名
     * @return 管理员账户信息
     */
    SysUser getSysUserByName(String userName);
}
