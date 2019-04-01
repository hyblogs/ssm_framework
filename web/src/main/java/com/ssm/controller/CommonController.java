package com.ssm.controller;

import com.ssm.entity.common.Constants;
import com.ssm.utils.imgutils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 * www.hyblogs.com
 *
 * @ClassName: CommonController
 * @Description: 通用控制器
 * @version: v1.0.0
 * @author: hy
 * @date: 2019-03-27 14:29
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2019-03-27   hy              v1.0.0             Is Create!
 */
@Controller
@RequestMapping(value = "/ssm_framework/back/")
public class CommonController {

    /**
     * 获取图形验证码
     * @param response 想要对象
     * @param session Session对象
     * @throws IOException 异常
     */
    @GetMapping(value = "getSecurityCode")
    public void authImg(HttpServletResponse response, HttpSession session) throws IOException {
        Map<String, Object> map = ImageUtil.generateCodeAndPic();
        session.setAttribute(Constants.AUTH_CODE_SESSION_KEY, String.valueOf(map.get("code")).toLowerCase());
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", response.getOutputStream());
    }
}
