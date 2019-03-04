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
@Table(name = "salary", schema = "logistics_manager", catalog = "")
public class SalaryPo {
    private int id;
    private Integer userId;
    private Double baseSalary;
    private Double performanceSalary;
    private Double takeOff;
    private Double total;
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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "base_salary")
    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Basic
    @Column(name = "performance_salary")
    public Double getPerformanceSalary() {
        return performanceSalary;
    }

    public void setPerformanceSalary(Double performanceSalary) {
        this.performanceSalary = performanceSalary;
    }

    @Basic
    @Column(name = "take_off")
    public Double getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(Double takeOff) {
        this.takeOff = takeOff;
    }

    @Basic
    @Column(name = "total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        SalaryPo salaryPo = (SalaryPo) o;
        return id == salaryPo.id &&
                Objects.equals(userId, salaryPo.userId) &&
                Objects.equals(baseSalary, salaryPo.baseSalary) &&
                Objects.equals(performanceSalary, salaryPo.performanceSalary) &&
                Objects.equals(takeOff, salaryPo.takeOff) &&
                Objects.equals(total, salaryPo.total) &&
                Objects.equals(createDate, salaryPo.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, baseSalary, performanceSalary, takeOff, total, createDate);
    }
}
