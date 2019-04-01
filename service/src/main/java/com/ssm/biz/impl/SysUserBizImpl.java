package com.ssm.biz.impl;

import com.hykit.exceptionutils.ApplicationException;
import com.ssm.biz.SysUserBiz;
import com.ssm.entity.mapping.SysUser;
import com.ssm.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysUserBizImpl
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-24 16:01
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-24   hy              v1.0.0             Is Create!
 */
@Service
public class SysUserBizImpl implements SysUserBiz {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getSysUserList(SysUser sysUser) throws ApplicationException {
        try {
            return this.sysUserMapper.select(sysUser);
        } catch (Exception e) {
            throw new ApplicationException(e);
        }
    }
}
