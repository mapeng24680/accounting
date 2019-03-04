package com.student.logistics.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
public class SignedVo {

    private int id;
    private Integer userId;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
