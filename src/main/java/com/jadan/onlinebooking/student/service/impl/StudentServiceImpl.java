package com.jadan.onlinebooking.student.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.student.entity.Student;
import com.jadan.onlinebooking.student.mapper.StudentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jadan.onlinebooking.student.service.StudentService;
import com.jadan.onlinebooking.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jadan-Z
 * @since 2018-11-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    // 学生注册
    @Override
    public void addStudent(JSONObject jsonObject) throws Exception {
        // 查找该账号是否被注册
        Integer isExist = studentMapper.findStudentAccount((String) jsonObject.get("account"));
        if(isExist > 0) {
            throw new Exception("该账号已被注册，请更换账号名");
        }

        // 未加密
        String pass = (String) jsonObject.get("pass");
        jsonObject.put("pass", MD5Utils.EncoderByMd5(pass));
        studentMapper.addStudent(jsonObject);
    }
}
