package com.student.accounting.service.impl;/**
 * Created by dell on 2019/3/5.
 */

import com.student.accounting.pojo.po.UserPo;
import com.student.accounting.pojo.vo.UserVo;
import com.student.accounting.repository.UserRepository;
import com.student.accounting.service.UserService;
import com.student.accounting.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description: 用户模块
 * @author: mapeng
 * @create: 2019-03-05 11:00
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVo findByAccount(String account) {
        UserPo userPo = userRepository.findByAccount(account);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userPo, userVo);
        return userVo;
    }

    @Override
    public void save(UserVo userVo) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userVo, userPo);
        userPo.setCreateTime(DateUtils.convertTimeToString(System.currentTimeMillis()));
        userPo.setUpdateTime(DateUtils.convertTimeToString(System.currentTimeMillis()));
        userRepository.save(userPo);
    }

    @Override
    public void update(UserVo userVo) {
        UserPo userPo = userRepository.getOne(userVo.getId());
        if (!StringUtils.isEmpty(userVo.getName())) {
            userPo.setName(userVo.getName());
        }
        if (!StringUtils.isEmpty(userVo.getPassword())) {
            userPo.setPassword(userVo.getPassword());
        }
        if (!StringUtils.isEmpty(userVo.getPosition())) {
            userPo.setPosition(userVo.getPosition());
        }
        if (!StringUtils.isEmpty(userVo.getPhone())) {
            userPo.setPhone(userVo.getPhone());
        }
        if (!StringUtils.isEmpty(userVo.getRoleId())) {
            userPo.setRoleId(userVo.getRoleId());
        }
        if (!StringUtils.isEmpty(userVo.getIdcard())) {
            userPo.setIdcard(userVo.getIdcard());
        }
        if (!StringUtils.isEmpty(userVo.getStatus())) {
            userPo.setStatus(userVo.getStatus());
        }
        if (!StringUtils.isEmpty(userVo.getIsDelete())) {
            userPo.setIsDelete(userVo.getIsDelete());
        }
        userPo.setUpdateTime(DateUtils.convertTimeToString(System.currentTimeMillis()));
    }
}
