package com.student.logistics.pojo.po;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
@Entity
@Table(name = "message", schema = "logistics_manager", catalog = "")
public class MessagePo {
    private int id;
    private String content;
    private Integer userId;
    private Date createDate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessagePo messagePo = (MessagePo) o;
        return id == messagePo.id &&
                Objects.equals(content, messagePo.content) &&
                Objects.equals(userId, messagePo.userId) &&
                Objects.equals(createDate, messagePo.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, userId, createDate);
    }
}
