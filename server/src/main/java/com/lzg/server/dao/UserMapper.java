package com.lzg.server.dao;

import com.lzg.server.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> selectUser();

}
