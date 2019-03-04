package com.student.logistics.repository;

import com.student.logistics.pojo.po.SignedPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
public interface SignedRepository extends JpaRepository<SignedPo, Integer> {
    List<SignedPo> findByUserId(Integer userId);
}
