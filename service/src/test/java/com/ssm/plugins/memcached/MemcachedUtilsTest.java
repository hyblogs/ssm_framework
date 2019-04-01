package com.ssm.plugins.memcached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MemcachedUtilsTest
 * @Description:
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-25 14:55
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-25   hy              v1.0.0             Is Create!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class MemcachedUtilsTest {

    @Autowired
    private MemcachedUtils memcachedUtils;

    @Test
    public void addTest() {
        String key = "test";
        String value = "Hello MemCached!!!";
        this.memcachedUtils.add(key, value);
    }

    @Test
    public void getTest() {
        String key = "test";
        Object object = this.memcachedUtils.get(key);
        System.out.println("Get = " + object);
    }

    @Test
    public void addAndVar3Test() {
        String key = "hy3";
        Object value = "520sdchaisdhcioashdcoiashicohalksdchkashdciouheioqiewhfkldwnckhqiuw" +
                "ehfioqwhefio238974892374897128947129374981723489qefjklqwejfiqwjeifjqowiefjh" +
                "fwiwef93u89ru1389u498ehfidhq83fhefuhqwueihfiquwh就啊好多风景画家快点放寒假巴萨" +
                "大手笔大家可否把圣诞节发生矛盾福卡都不放假 e发看啦是第发和ioqheifhqiwoefhiqweifhqu" +
                "eiwhfiuqehwfiuh气氛好去iwehfuiqwebkjasdbciuqwefwkjenjenf叫我饿减肥 i 恶化 iu 复" +
                "合物 i 发货返回 i 哦前未婚夫 i 哦请问黑发哇诶哦风景区位哦 i 减肥 i 为全家福 i 价位附" +
                "近哦起微积分 i 哦前肌肤极其恶无法可我却能克服呢我";
        boolean isAdd = this.memcachedUtils.add(key, value, 1);
        System.out.println("IsAdd Success = " + isAdd);
    }
}
