package com.student.logistics.repository;

import com.student.logistics.pojo.po.DeptPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
public interface DeptRepository extends JpaRepository<DeptPo, Integer>, JpaSpecificationExecutor<DeptPo> {
}
