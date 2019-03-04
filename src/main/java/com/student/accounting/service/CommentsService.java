package com.student.logistics.service;

import com.student.logistics.pojo.vo.CommentsVo;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
public interface CommentsService {

    /**
     * 新增评价
     * @param vo
     */
    void addComments(CommentsVo vo);

    /**
     * 查询自己的评价
     * @param userId 被评价人的id
     * @return
     */
    List<CommentsVo> findComments(Integer userId);
}
