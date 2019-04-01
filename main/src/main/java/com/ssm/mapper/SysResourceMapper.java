package com.ssm.mapper;

import com.ssm.entity.mapping.SysResource;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

public interface SysResourceMapper extends Mapper<SysResource>, MySqlMapper<SysResource> {

    /**
     * 根据后台管理员账户ID查询对应账户角色下的后台菜单资源信息
     * @param params 查询条件
     * @return 后台菜单资源信息
     */
    List<SysResource> getSysResourceByUserId(Map<String, Object> params);

    /**
     * 根据查询条件获取对应的后台菜单资源信息
     * @param params 查询条件
     * @return 后台资源信息
     */
    List<SysResource> getSysResourceList(Map<String, Object> params);
}