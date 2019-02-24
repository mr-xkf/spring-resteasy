/**
 * FileName: UserController
 * Author:   13235
 * Date:     2019/1/29 0:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/29
 * @since 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userService.editUser(user);
        return "保存成功！";
    }


    @GetMapping("/page")
    public Page<User> pageUser(String password) {
        PageRequest pageRequest = PageRequest.of(0, 10);
        User u = new User();
        u.setPassword(password);
        Page<User> userByCondition = userService.findUserByCondition(u, pageRequest);
        return userByCondition;
    }
}
