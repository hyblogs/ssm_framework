package com.ssm.mapper;

import com.ssm.entity.mapping.SysUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SysUserMapper extends Mapper<SysUser>, MySqlMapper<SysUser> {
}