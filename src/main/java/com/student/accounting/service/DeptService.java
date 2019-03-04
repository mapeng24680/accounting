package com.student.logistics.service;

import com.student.logistics.pojo.vo.DeptVo;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
public interface DeptService {

    /**
     * 新增
     * @param deptVo
     */
    void addDept(DeptVo deptVo);

    /**
     * 删除
     * @param id
     */
    void deleteDept(Integer id);

    /**
     * 更新
     * @param deptVo
     */
    void updateDept(DeptVo deptVo);

    List<DeptVo> findByCondition(DeptVo deptVo);
}
