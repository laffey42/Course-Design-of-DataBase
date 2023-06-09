package com.yzu.edu.service;

import com.yzu.edu.mapper.UserMapper;
import com.yzu.edu.pojo.User;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User selectSingle(String username, String password) {
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectSingle(username, password);
        session.close();
        return user;
    }

    public void updateSingle(int uid, String username, String password) {
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateSingle(uid, username, password);
        session.commit();
        session.close();
    }

}
