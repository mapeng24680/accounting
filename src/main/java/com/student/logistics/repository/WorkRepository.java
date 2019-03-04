package com.student.logistics.repository;

import com.student.logistics.pojo.po.WorkPo;
import com.student.logistics.pojo.vo.WorkVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
public interface WorkRepository extends JpaRepository<WorkPo, Integer> {
    List<WorkPo> findByUserId(Integer userId);
}
