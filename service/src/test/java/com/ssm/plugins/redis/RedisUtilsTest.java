package com.ssm.plugins.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: RedisUtilsTest
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-25 14:01
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-25   hy              v1.0.0             Is Create!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class RedisUtilsTest {

    @Resource
    private RedisUtils redisUtils;

    @Test
    public void setTest() {
        redisUtils.set("test", "Hello Redis!");
    }

    @Test
    public void getTest() {
        Object object = redisUtils.get("test");
        System.out.println("Get = " + object);
    }
}
