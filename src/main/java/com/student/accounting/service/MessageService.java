package com.student.logistics.service;

import com.student.logistics.pojo.vo.MessageVo;

import java.util.List;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
public interface MessageService {

    void addMessage(MessageVo vo);
    //公告只轮询最新十条,前端提取
    List<MessageVo> findMessage();
}
