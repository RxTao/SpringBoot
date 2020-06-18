package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: Controller公共组件
 * @User: zhang
 * @Date: 2020-05-08 10:34
 **/
@RestController
public class AbstractController {

    /**
     * 得到request对象
     */
    @Autowired
    protected HttpServletRequest request;
    /**
     * 得到response对象
     */
    @Autowired
    protected HttpServletResponse response;



    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    public String getClientIp() {
        String ipaddress = request.getHeader("X-Real-IP");
        if (ipaddress == null) {
            ipaddress = request.getHeader("X-Forwarded-For");
        }
        if (ipaddress == null) {
            ipaddress = request.getRemoteAddr();
        } else {
            int index = ipaddress.indexOf(',');
            if (index != -1) {
                ipaddress = ipaddress.substring(0, index);
            }
        }
        return ipaddress;
    }

    /**
     * 功能描述: 构建统一格式返回对象
     *
     * @Param requestCode
     * @Param msg
     * @Param data
     * @Return Map
     * @User zhang
     * @Date 2020/5/8 10:35
     */
    public Map<String, Object> toResponsObject(int requestCode, String msg, Object data) {
        Map<String, Object> obj = new HashMap<>();
        obj.put("code", requestCode);
        obj.put("errmsg", msg);
        if (data != null) obj.put("data", data);

        return obj;
    }

    public Map<String, Object> toResponsSuccess(Object data) {
        return toResponsObject(0, "执行成功", data);
    }

    public Map<String, Object> toResponsFail(int code, String msg) {
        return toResponsObject(code, msg, null);
    }

}
