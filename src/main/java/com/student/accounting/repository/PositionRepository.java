package com.student.logistics.repository;

import com.student.logistics.pojo.po.PositionPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
public interface PositionRepository extends JpaRepository<PositionPo, Integer>, JpaSpecificationExecutor<PositionPo> {
    List<PositionPo> findByDeptId(Integer deptId);
}
