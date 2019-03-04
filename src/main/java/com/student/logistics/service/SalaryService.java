package com.student.logistics.service;

import com.student.logistics.pojo.vo.SalaryVo;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description: 工资管理服务
 * @ date: 2019/3/3.
 */
public interface SalaryService {

    /**
     * 新增
     * @param salaryVo
     */
    void addSalary(SalaryVo salaryVo);

    /**
     * 查询所有工资
     * @param userId
     * @return
     */
    List<SalaryVo> findSalary(SalaryVo condition);
}
