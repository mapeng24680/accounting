package com.student.logistics.repository;

import com.student.logistics.pojo.po.MessagePo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
public interface MessageRepository extends JpaRepository<MessagePo, Integer> {

    @Query(value = "select * from message order by id desc  limit 10", nativeQuery = true)
    List<MessagePo> findMessage();
}
