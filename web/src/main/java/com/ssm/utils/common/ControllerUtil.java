package com.ssm.utils.common;

import com.hykit.common.ResultTip;
import com.hykit.logutils.LogHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: ControllerUtil
 * @Description: Controller控制器公共类
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-28 13:21
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-28   hy              v1.0.0             Is Create!
 */
public class ControllerUtil {

    /**
     * 获取HTTP请求头对象
     * @return HttpHeaders
     */
    public static HttpHeaders getHttpHeaders() {
        //初始化http头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
    }

    /**
     * 包装响应信息
     * @param resultTip 响应结果对象
     * @return ResponseEntity
     */
    public static ResponseEntity<ResultTip> getResponseEntity(ResultTip resultTip) {
        LogHelper.logResponse("Controller响应信息", resultTip);
        return new ResponseEntity<ResultTip>(resultTip, getHttpHeaders() , HttpStatus.OK);
    }
}
