package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setPassword("22");
        user.setUserName("啊哈哈");
        userRepo.insertUser(user);

    }

    @Test
    public void test2() {
        PageRequest  pageRequest=PageRequest.of(0,10, Sort.Direction.DESC,"uid");
        Page<User> xx = userRepo.nativeByPage("xx", pageRequest);
        xx.getContent().forEach(s-> System.out.println(s.toString()));
    }

}

