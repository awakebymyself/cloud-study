package com.lzg.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzg.server.dao.UserPlusMapper;
import com.lzg.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserPlusMapper, User> implements UserService {

    @Autowired
    private UserPlusMapper userPlusMapper;

    @Override
    public User getUser() {
        User user = new User();
        user.setAge(100);
        return user;

    }

    @Override
    public IPage<User> selectUserPage(Page<User> page) {
        return userPlusMapper.selectPageVo(page);
    }


}
