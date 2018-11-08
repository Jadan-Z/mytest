package com.jadan.onlinebooking.student.mapper;

import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.student.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Jadan-Z
 * @since 2018-11-05
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    // 在注册前：先看是否有该账号的存在
    Integer findStudentAccount(String account);

    // 学生注册
    void addStudent(JSONObject jsonObject);
}
