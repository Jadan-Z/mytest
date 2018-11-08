package com.jadan.onlinebooking.login.service;

import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.login.entity.Headmaster;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Jadan-Z
 * @since 2018-11-06
 */
public interface LoginService extends IService<Headmaster> {

    // 匹配学生账号和密码
    void findStudentPassByAccount(JSONObject jsonObject) throws Exception;

    // 匹配教师账号
    void findTeacherPassByAccount(JSONObject jsonObject) throws Exception;

    // 匹配校长账号
    void findHeadmasterPassByAccount(JSONObject jsonObject) throws Exception;

}
