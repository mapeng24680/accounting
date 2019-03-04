package com.student.logistics.repository;

import com.student.logistics.pojo.po.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ZhongLiang.Xian
 * @ description:
 * @ date: 2019/3/2.
 */
public interface UserRepository extends JpaRepository<UserPo, Integer>,JpaSpecificationExecutor<UserPo> {
    @Query(value = "update user set status = 0 where id = ?1", nativeQuery = true)
    @Modifying
    void deleteUser(Integer id);

    /**
     * 删除人员岗位信息
     */
    @Query(value = "update user set position = 0 where position = ?1",nativeQuery = true)
    @Modifying
    void updatePosition(Integer positionId);

    UserPo findByAccountAndPassword(String account, String password);
}
