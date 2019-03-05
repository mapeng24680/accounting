package com.student.accounting.service;

import com.student.accounting.pojo.vo.UserVo;

/**
 * @author mapeng
 * @ description: 用户模块
 * Created by dell on 2019/3/5.
 */
public interface UserService {
    /**
     * 登录
     * @param account
     * @return
     */
    UserVo findByAccount(String account);

    /**
     * 注册
     * @param userVo
     */
    void save(UserVo userVo);

    /**
     * 更新用户信息
     * @param userVo
     */
    void update(UserVo userVo);
}
