package com.quan.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_user")
public class User extends BasePojo{
    private Long id;
    private String mobile; //手机号

    @JsonIgnore
    private String password; //密码，json序列化时忽略
}
