/**
 * FileName: UserRepo
 * Author:   13235
 * Date:     2019/1/28 22:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/28
 * @since 1.0.0
 */
public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByPassword(String password);

    /**
     * 使用命名参数
     *
     * @param password
     * @return
     */
    @Query("select p from User  p where p.password=:password ")
    List<User> withPwd(@Param("password") String password);

    /**
     * 使用位置参数
     *
     * @param password
     * @return
     */
    @Query("select p from User p where p.password=?1 ")
    List<User> withPwdByPosition(String password);

    /**
     * 删除操作
     *
     * @param uid
     */
    @Query("delete from User u where u.uid=?1 ")
    @Modifying
    @Transactional
    void deletByUid(Integer uid);

    /**
     * 修改操作
     *
     * @param userName
     * @param uid
     */
    @Query("update User u set u.userName=?1 where u.uid=?2")
    @Modifying
    @Transactional
    void updateUser(String userName, Integer uid);

    /**
     * 分页查询
     *
     * @param userName
     * @param pageable
     * @return
     */
    Page<User> findByUserName(String userName, Pageable pageable);

    @Query(value = "select * from user where user.username=?1 ", countQuery = "select count(*) from user ", countName = "c", countProjection = "c2", nativeQuery = true)
    Page<User> nativeByPage(String userName, Pageable pageable);

    /**
     * 插入操作
     */
    @Query(value = "insert into user(username, password) VALUES(:#{#u.userName},:#{#u.password})", nativeQuery = true)
    @Modifying
    @Transactional
    void insertUser(@Param("u") User user);
}

