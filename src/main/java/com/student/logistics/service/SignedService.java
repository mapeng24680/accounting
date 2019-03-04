package com.student.logistics.service;

import com.student.logistics.pojo.vo.SignedVo;
import com.student.logistics.pojo.vo.WorkVo;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description: 排班登记服务
 * @ date: 2019/3/2.
 */
public interface SignedService {

    /**
     * 签到登记
     * @param userId
     */
    void signed(Integer userId);

    /**
     * 查询已完成登记列表
     * @param userId
     * @return
     */
    List<SignedVo> findByUser(Integer userId);

    /**
     * 新增排班
     */
    void addWork(WorkVo vo);

    /**
     * 查询排班情况
     * @return
     */
    List<WorkVo> findWork(Integer userId);

}
