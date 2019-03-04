package com.student.logistics.service.impl;

import com.student.logistics.pojo.po.CommentsPo;
import com.student.logistics.pojo.vo.CommentsVo;
import com.student.logistics.repository.CommentsRepository;
import com.student.logistics.repository.UserRepository;
import com.student.logistics.service.CommentsService;
import com.student.logistics.utils.DTOConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private UserRepository userRepository;
    private DTOConverterUtils<CommentsPo, CommentsVo> converterUtils = new DTOConverterUtils<>(CommentsPo.class, CommentsVo.class);

    @Override
    public void addComments(CommentsVo vo) {
        vo.setCreateDate(new Date());
        commentsRepository.save(converterUtils.toPO(vo));
    }

    @Override
    public List<CommentsVo> findComments(Integer userId) {
        List<CommentsPo> pos = commentsRepository.findByReceiveUserId(userId);
        List<CommentsVo> commentsVos = converterUtils.toDTOList(pos);
        //封装评价人姓名功前端展示
        commentsVos.forEach(vo -> {
            userRepository.findById(vo.getPublishUserId()).ifPresent(po -> vo.setPublishUserName(po.getName()));
        });
        return commentsVos;
    }
}
