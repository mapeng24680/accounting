package com.student.logistics.repository;

import com.student.logistics.pojo.po.SalaryPo;
import com.student.logistics.pojo.vo.SalaryVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
public interface SalaryRepository extends JpaRepository<SalaryPo, Integer>, JpaSpecificationExecutor<SalaryPo> {

    @Query(value = "select s.* from salary s left join user u on u.id = s.user_id where u.name like CONCAT('%',?1,'%') ",nativeQuery = true)
    List<SalaryPo> findByUserName(String userName);
}
