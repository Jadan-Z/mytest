package com.jadan.onlinebooking.student.controller;


import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.student.service.StudentService;
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
 * @since 2018-11-05
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 学生注册
    @PostMapping(value = "/register")
    void addStudent(HttpServletRequest request,
                    HttpServletResponse response,
                    @RequestBody JSONObject jsonObject) throws IOException {

        try {
            studentService.addStudent(jsonObject);
        } catch (Exception e) {
            response.sendError(400, e.getMessage());
        }
    }

}

