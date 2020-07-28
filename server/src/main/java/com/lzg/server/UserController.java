package com.lzg.server;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzg.server.dao.UserMapper;
import com.lzg.server.dao.UserPlusMapper;
import com.lzg.server.model.User;
import com.lzg.server.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPlusMapper userPlusMapper;

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public String getUser() {
        List<User> users = userMapper.selectUser();
         return users.stream().map(User::toString).collect(Collectors.joining(","));
    }

    @GetMapping("getUser2")
    public String getUser2() {
        List<User> users = userPlusMapper.selectList(null);
        return users.stream().map(User::toString).collect(Collectors.joining(","));
    }

    @GetMapping("getUser3")
    public String getUser3() {
        User one = userService.lambdaQuery().eq(User::getId, 1).one();
        System.out.println("One:" + one);

        Page<User> page = new Page<>(0, 3);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        IPage<User> userIPage = userService.selectUserPage(page);

        long total1 = userIPage.getTotal();
        System.out.println("total:" + total1);

        System.out.println(userIPage.getRecords().stream().map(User::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(",")));


        queryWrapper.gt("id", 1);
        Page<User> userPage = userService.page(page, queryWrapper);
        long total = userPage.getTotal();
        System.out.println("total:" + total);

        return userPage.getRecords().stream().map(User::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @PostMapping("insert")
    public String insertUser() {
        User user = new User();
        user.setAge(100);
        user.setEmail("lzg");
        user.setName("maomao");
        user.setAddTime(new Date());
        userPlusMapper.insert(user);

        return "" + user.getId();
    }

}
