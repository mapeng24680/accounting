package com.student.logistics.repository;

import com.student.logistics.pojo.po.CommentsPo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
public interface CommentsRepository extends JpaRepository<CommentsPo, Integer> {
    /**
     * 根据被评价人id查询
     * @param userId
     * @return
     */
    List<CommentsPo> findByReceiveUserId(Integer userId);
}
