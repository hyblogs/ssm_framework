package com.ssm.mapper;

import com.hykit.objectutils.ObjectKit;
import com.ssm.entity.mapping.SysResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: SysResourceMapperTest
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 20:28
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class SysResourceMapperTest {

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Test
    public void getSysResourceByUidTest() {
        Long userId = 1L;
        Map<String, Object> params = new HashMap<>(16);
        params.put("userId", userId);
        List<SysResource> sysResourceList = this.sysResourceMapper.getSysResourceByUserId(params);
        //List<SysResource> sysResourceList = this.sysResourceMapper.selectAll();
        System.out.println(sysResourceList);
    }

    @Test
    public void objectUtilTest() {
        SysResource sysResource = new SysResource();
        sysResource.setId(1L);
        sysResource.setResourceName("test");
        Map<String, Object> resultMap = ObjectKit.makeQueryMapOverlookStatic(sysResource, null, true);
        Iterator<Map.Entry<String, Object>> iterator = resultMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
