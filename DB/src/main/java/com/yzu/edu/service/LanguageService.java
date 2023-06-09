package com.yzu.edu.service;

import com.yzu.edu.mapper.LanguageMapper;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LanguageService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public int selectNumOfLan(){
        SqlSession session = factory.openSession();
        LanguageMapper mapper = session.getMapper(LanguageMapper.class);
        int num = mapper.selectNumOfLan();
        session.close();
        return num;
    }


}
