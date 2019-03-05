package com.student.accounting.repository;


import com.student.accounting.pojo.po.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author mapeng
 * @ description:
 * @ date: 2019/3/5.
 */
public interface UserRepository extends JpaRepository<UserPo, Integer>,JpaSpecificationExecutor<UserPo> {
//    @Query(value = "update user set status = 0 where id = ?1", nativeQuery = true)
//    @Modifying
//    void deleteUser(Integer id);
//
//    /**
//     * 删除人员岗位信息
//     */
//    @Query(value = "update user set position = 0 where position = ?1",nativeQuery = true)
//    @Modifying
//    void updatePosition(Integer positionId);

    UserPo findByAccount(String account);

    void findOne(int id);
}
