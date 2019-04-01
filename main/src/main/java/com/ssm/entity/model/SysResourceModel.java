package com.ssm.entity.model;

import com.ssm.entity.mapping.SysResource;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysResourceModel
 * @Description: 系统栏目信息模型对象
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 21:52
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
public class SysResourceModel extends SysResource {

    /** 系统栏目信息列表 */
    private List<SysResource> sysResourceList;

    /**
     * 获取 系统栏目信息列表
     *
     * @return sysResourceList 系统栏目信息列表
     */
    public List<SysResource> getSysResourceList() {
        return this.sysResourceList;
    }

    /**
     * 设置 系统栏目信息列表
     *
     * @param sysResourceList 系统栏目信息列表
     */
    public void setSysResourceList(List<SysResource> sysResourceList) {
        this.sysResourceList = sysResourceList;
    }
}
