/**
 * FileName: UserServiceImpl
 * Author:   13235
 * Date:     2019/1/28 22:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.service.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getById(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editUser(User user) {
        user.setUserName("xx");
        if (user.getUid() == null) {
            userRepo.save(user);
        }
        System.out.println(user.toString());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleUser(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public Page<User> findUserByCondition(User user, Pageable pageable) {
        user.setUid(2);
        Example<User> example = Example.of(user, ExampleMatcher.matching());
        return userRepo.findAll(example, pageable);
    }
}
