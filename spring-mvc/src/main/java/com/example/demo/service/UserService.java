/**
 * FileName: UserService
 * Author:   13235
 * Date:     2019/1/28 22:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/28
 * @since 1.0.0
 */

public interface UserService {

    /**
     *
     * 根据id查询用户信息
     * @param id
     * @return User
     *
     */
    User getById(Integer id);

    /**
     *
     * 查询所有用户信息
     *
     * @return List<User>
     */
    List<User> getAll();

    /**
     *
     * 编辑用户信息
     *
     * @param user
     */
    void editUser(User user);


    /**
     *
     * 根据id删除用户信息
     * @param id
     *
     */
    void deleUser(Integer id);


    /**
     *
     * 根据查询条件分页展示列表
     * @param paramMap
     * @param pageable
     * @return
     *
     */
    Page<User> findUserByCondition(User user, Pageable pageable);

}
