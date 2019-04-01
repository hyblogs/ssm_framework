package com.ssm.mapper;

import com.ssm.entity.mapping.SiteUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SiteUserMapper extends Mapper<SiteUser>, MySqlMapper<SiteUser> {
}