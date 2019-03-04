package com.student.logistics.pojo.po;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
@Entity
@Table(name = "user", schema = "logistics_manager", catalog = "")
public class UserPo {
    private int id;
    private String account;
    private String name;
    private String password;
    private Integer position;
    private String idCard;
    private String phone;
    private int status;
    private String address;

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
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "position")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Basic
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPo userPo = (UserPo) o;
        return id == userPo.id &&
                status == userPo.status &&
                Objects.equals(account, userPo.account) &&
                Objects.equals(name, userPo.name) &&
                Objects.equals(password, userPo.password) &&
                Objects.equals(position, userPo.position) &&
                Objects.equals(idCard, userPo.idCard) &&
                Objects.equals(phone, userPo.phone) &&
                Objects.equals(address, userPo.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, account, name, password, position, idCard, phone, status, address);
    }
}
