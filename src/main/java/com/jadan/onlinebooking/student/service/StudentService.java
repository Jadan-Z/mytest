package com.jadan.onlinebooking.student.service;

import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.student.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jadan-Z
 * @since 2018-11-05
 */
public interface StudentService extends IService<Student> {

    // 学生注册
    void addStudent(JSONObject jsonObject) throws Exception;

}
