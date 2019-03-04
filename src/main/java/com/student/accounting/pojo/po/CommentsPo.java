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
@Table(name = "comments", schema = "logistics_manager", catalog = "")
public class CommentsPo {
    private int id;
    private Integer receiveUserId;
    private Integer publishUserId;
    private String content;
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
    @Column(name = "receive_user_id")
    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    @Basic
    @Column(name = "publish_user_id")
    public Integer getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Integer publishUserId) {
        this.publishUserId = publishUserId;
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
        CommentsPo that = (CommentsPo) o;
        return id == that.id &&
                Objects.equals(receiveUserId, that.receiveUserId) &&
                Objects.equals(publishUserId, that.publishUserId) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, receiveUserId, publishUserId, content);
    }
}
