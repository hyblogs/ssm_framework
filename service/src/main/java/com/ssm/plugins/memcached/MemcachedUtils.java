package com.ssm.plugins.memcached;

import com.hykit.logutils.LogHelper;
import com.whalin.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: MemcachedUtils
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
@Component
public class MemcachedUtils {

    /** MemCached连接对象 */
    private final MemCachedClient memCachedClient;

    @Autowired
    public MemcachedUtils(MemCachedClient memCachedClient) {
        this.memCachedClient = memCachedClient;
    }

    /**
     * 向MemCached加入数据
     * 注：如果要加入的key已经存在则加入Key-Value失败
     * @param key 加入数据的Key
     * @param value 加入数据的Value
     * @return 是否加入成功：true/false
     */
    public boolean add(String key, Object value) {
        LogHelper.print("向MemCache加入数据(常规加入数据)", new String[]{"key", "value"}, key, value);
        try {
            return this.memCachedClient.add(key, value);
        } catch (Exception e) {
            LogHelper.error("Add To MemCached Error", e);
        }
        return false;
    }

    /**
     * 向MemCached加入数据(含失效时间)
     * 注：如果要加入的key已经存在则加入Key-Value失败
     * @param key 加入数据的Key
     * @param value 加入数据的Value
     * @param var3 失效时间
     * @return 是否加入成功：true/false
     */
    public boolean add(String key, Object value, Date var3) {
        LogHelper.print("向MemCache加入数据(含数据失效时间)", new String[]{"key", "value", "var3"}, key, value, var3);
        try {
            return this.memCachedClient.add(key, value, var3);
        } catch (Exception e) {
            LogHelper.error("Add To MemCached Error", e);
        }
        return false;
    }

    /**
     * 向MemCache加入数据(是否启用压缩)
     * 注：如果要加入的key已经存在则加入Key-Value失败
     * @param key 加入数据的Key
     * @param value 加入数据的Value
     * @param var3 是否压缩
     * @return 是否加入成功：true/false
     */
    public boolean add(String key, Object value, Integer var3) {
        LogHelper.print("向MemCache加入数据(含数据类型是否字符串)", new String[]{"key", "value", "var3"}, key, value, var3);
        try {
            return this.memCachedClient.add(key, value, var3);
        } catch (Exception e) {
            LogHelper.error("Add To MemCached Error", e);
        }
        return false;
    }

    /**
     * 向MemCache加入数据
     * 注：如果要加入的key已经存在则加入Key-Value失败
     * @param key 加入数据的Key
     * @param value 加入数据的Value
     * @param var3 设置的数据失效时间
     * @param var4 是否启用压缩
     * @return 是否加入成功：true/false
     */
    public boolean add(String key, Object value, Date var3, Integer var4) {
        LogHelper.print(new String[]{"key", "value", "expTime", "var4"}, key, value, var3, var4);
        try {
            return this.memCachedClient.add(key, value, var3, var4);
        } catch (Exception e) {
            LogHelper.error("Add To MemCached Error", e);
        }
        return false;
    }

    /**
     * 向MemCached中设置数据
     * 注：如果要加入的key已经存在则替换已存在key对应的Value值
     *     key不存在则新增对应的Key-Value键值对
     * @param key 要设置数据的键-Key
     * @param value 要设置数据的值-Value
     * @return 是否设置成功：true/false
     */
    public boolean set(String key, Object value) {
        LogHelper.print(new String[]{"key", "value"}, key, value);
        try {
            return this.memCachedClient.set(key, value);
        } catch (Exception e) {
            LogHelper.error("Set To MemCached Error", e);
        }
        return false;
    }

    /**
     * 向MemCached设置数据值
     * 注：如果要加入的key已经存在则替换已存在key对应的Value值
     *     key不存在则新增对应的Key-Value键值对
     * @param key 要设置数据的键-Key
     * @param value 要设置数据的值-Value
     * @param expTime 设置数据失效时间
     * @return 是否设置成功：true/false
     */
    public boolean set(String key, Object value, Date expTime) {
        LogHelper.print(new String[]{"key", "value", "expTime"}, key, value, expTime);
        try {
            return this.memCachedClient.set(key, value, expTime);
        } catch (Exception e) {
            LogHelper.error("Set To MemCached Error", e);
        }
        return false;
    }

    /**
     * 替换MemCached里面的数据
     * @param key 需要替换数据的Key
     * @param value 需要替换的后的数据值Value
     * @return 是否替换成功：true/false
     */
    public boolean replace(String key, Object value) {
        LogHelper.print(new String[]{"key", "value"}, key, value);
        try {
            return this.memCachedClient.replace(key, value);
        } catch (Exception e) {
            LogHelper.error("Replace For MemCached Error", e);
        }
        return false;
    }

    /**
     * 替换MemCached里面的数据(带设置失效时间)
     * @param key 需要替换数据的Key
     * @param value 需要替换的后的数据值Value
     * @param expTime 需要替换后设置的数据失效时间
     * @return 是否替换成功：true/false
     */
    public boolean replace(String key, Object value, Date expTime) {
        LogHelper.print(new String[]{"key", "value", "expTime"}, key, value, expTime);
        try {
            return this.memCachedClient.replace(key, value);
        } catch (Exception e) {
            LogHelper.error("Replace For MemCached Error", e);
        }
        return false;
    }

    /**
     * 删除MemCached里面的数据
     * @param key 要删除的数据对应的Key值
     * @return 是否删除成功：true/false
     */
    public boolean delete(String key) {
        LogHelper.print(new String[]{"key"}, key);
        try {
            return this.memCachedClient.delete(key);
        } catch (Exception e) {
            LogHelper.error("Delete From MemCached Error", e);
        }
        return false;
    }

    /**
     * 根据MemCached中的键和失效时间删除对应的数据
     * @param key 要删除的数据对应的键-Key
     * @param expTime 要删除数据的失效时间
     * @return 是否删除成功：true/false
     */
    public boolean delete(String key, Date expTime) {
        LogHelper.print(new String[]{"key", "expTime"}, key, expTime);
        try {
            return this.memCachedClient.delete(key, expTime);
        } catch (Exception e) {
            LogHelper.error("Delete From MemCached Error", e);
        }
        return false;
    }

    /**
     * 根据Key获取MemCached中对应的键值数据
     * @param key 要获取的数据对应的键-Key
     * @return 返回键对应的值
     */
    public Object get(String key) {
        LogHelper.print(new String[]{"key"}, key);
        try {
            return this.memCachedClient.get(key);
        } catch (Exception e) {
            LogHelper.error("Get From MemCached Error", e);
            return null;
        }
    }


    //......更多方法参考源码(MemCachedClient.class)
}
