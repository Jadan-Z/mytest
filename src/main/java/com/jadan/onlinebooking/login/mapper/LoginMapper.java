package com.jadan.onlinebooking.login.mapper;

import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.login.entity.Headmaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Jadan-Z
 * @since 2018-11-06
 */
@Repository
public interface LoginMapper extends BaseMapper<Headmaster> {

    // 匹配学生账号
    String findStudentPassByAccount(String account);

    // 匹配教师账号
    String findTeacherPassByAccount(String account);

    // 匹配校长账号
    String findHeadmasterPassByAccount(String account);
}
