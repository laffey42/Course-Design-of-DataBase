package com.yzu.edu.mapper;

import com.yzu.edu.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectSingle(@Param("username") String username, @Param("password") String password);

    void updateSingle(@Param("uid") int uid, @Param("username") String username, @Param("password") String password);

}
