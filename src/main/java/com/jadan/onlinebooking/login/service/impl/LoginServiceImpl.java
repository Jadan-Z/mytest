package com.jadan.onlinebooking.login.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jadan.onlinebooking.login.entity.Headmaster;
import com.jadan.onlinebooking.login.mapper.LoginMapper;
import com.jadan.onlinebooking.login.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jadan.onlinebooking.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jadan-Z
 * @since 2018-11-06
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Headmaster> implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    // 匹配学生账号和密码
    @Override
    public void findStudentPassByAccount(JSONObject jsonObject) throws Exception {
        // 查看是否有匹配的账号
        String pass = loginMapper.findStudentPassByAccount((String) jsonObject.get("account"));
        // 判断是否有密码
        if(pass == null) {
            throw new Exception("该用户暂未注册,赶紧去注册呗....");
        }

        // 判断密码是否匹配
        if(!pass.equals(MD5Utils.EncoderByMd5((String) jsonObject.get("pass")))) {
            throw new Exception("密码有误,请核对密码...");
        }
    }

    // 匹配教师账号
    @Override
    public void findTeacherPassByAccount(JSONObject jsonObject) throws Exception {
        // 查看是否有匹配的账号
        String pass = loginMapper.findTeacherPassByAccount((String)jsonObject.get("account"));
        // 判断是否有密码
        if(pass == null) {
            throw new Exception("该账号校长暂未添加,请联系校长(153111030)");
        }

        // 判断密码是否匹配
        if(!pass.equals(MD5Utils.EncoderByMd5((String) jsonObject.get("pass")))) {
            throw new Exception("密码有误,请核对密码...");
        }
    }

    // 匹配校长账号
    @Override
    public void findHeadmasterPassByAccount(JSONObject jsonObject) throws Exception {
        // 查看是否有匹配的账号
        String pass = loginMapper.findHeadmasterPassByAccount((String) jsonObject.get("account"));
        // 判断是否有密码
        if(pass == null) {
            throw new Exception("校长账号还没添加");
        }

        // 判断密码是否匹配
        if(!pass.equals(MD5Utils.EncoderByMd5((String) jsonObject.get("pass")))) {
            throw new Exception("密码有误,请核对密码");
        }
    }
}
