package com.student.logistics.pojo.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
@Entity
@Table(name = "signed", schema = "logistics_manager", catalog = "")
public class SignedPo {
    private int id;
    private Integer userId;
    private Date time;

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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignedPo signedPo = (SignedPo) o;
        return id == signedPo.id &&
                Objects.equals(userId, signedPo.userId) &&
                Objects.equals(time, signedPo.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, time);
    }
}
