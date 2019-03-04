package com.student.logistics.pojo.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/3.
 */
@Entity
@Table(name = "work", schema = "logistics_manager", catalog = "")
public class WorkPo {
    private int id;
    private int userId;
    private Date startDate;
    private Date endDate;

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
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkPo workPo = (WorkPo) o;
        return id == workPo.id &&
                userId == workPo.userId &&
                Objects.equals(startDate, workPo.startDate) &&
                Objects.equals(endDate, workPo.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, startDate, endDate);
    }
}
