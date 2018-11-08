package com.jadan.onlinebooking.login.controller;


import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jadan-Z
 * @since 2018-11-06
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录验证
     * @param request
     * @param response
     * @param paramJson
     */
    @PostMapping(value = "/login")
    void checkRoleAndPass(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestBody JSONObject paramJson) throws IOException {
        try {
            // 获取身份
            Integer role = (Integer) paramJson.get("role");
            // role : 3(学生)、6(教师)、9(校长)
            if(role == 3) {
                loginService.findStudentPassByAccount(paramJson);
            } else if(role == 6) {
                loginService.findTeacherPassByAccount(paramJson);
            } else if(role == 9) {
                loginService.findHeadmasterPassByAccount(paramJson);
            }
            return;
        } catch (Exception e) {
            response.sendError(400, e.getMessage());
        }

    }

}

