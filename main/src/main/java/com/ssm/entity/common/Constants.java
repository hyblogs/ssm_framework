package com.ssm.entity.common;

import com.hykit.encodeutils.EncodeUtil;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: Constants
 * @Description: 系统常量
 * @version: v1.0.0
 * @author: HY
 * @date: 2018-08-12 10:01
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-08-12   HY              v1.0.0             修改原因
 */
public class Constants {

    public static final String SESSSION_USER = "SESSION_USER";

    public static final String SALT_ID_NUMBER  = "7ac63dc67cc712be0f94847ff915bbd3";
    public static final byte[] SALT_ID_NUMBER_KEY = EncodeUtil.decodeHex(SALT_ID_NUMBER);

    /** 登录名 */
    public static final String ADMIN_SESSION_KEY = "superAdmin";
    /** 验证码 */
    public static final String AUTH_CODE_SESSION_KEY = "authCode";

    public static final String REQUEST_METHOD_POST = "post";
    public static final String REQUEST_METHOD_GET = "get";

    /** 日志tag */
    public static final String LOG_TAG = "SSM-Framework-Back";
}
