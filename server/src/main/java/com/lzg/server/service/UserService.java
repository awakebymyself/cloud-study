package com.lzg.server.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lzg.server.model.User;

public interface UserService extends IService<User> {


    User getUser();

  IPage<User> selectUserPage(Page<User> page);

}
