package com.lzg.server.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;

    private Date addTime;

}
