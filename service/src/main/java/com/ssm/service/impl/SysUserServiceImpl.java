package com.ssm.service.impl;

import com.ssm.biz.SysUserBiz;
import com.ssm.entity.mapping.SysUser;
import com.ssm.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysUserServiceImpl
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-24 16:06
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-24   hy              v1.0.0             Is Create!
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserBiz sysUserBiz;

    @Override
    public SysUser getSysUserByName(String userName) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        List<SysUser> sysUserList = this.sysUserBiz.getSysUserList(sysUser);
        if (sysUserList == null || sysUserList.isEmpty()) {
            return null;
        } else {
            return sysUserList.get(0);
        }
    }
}
