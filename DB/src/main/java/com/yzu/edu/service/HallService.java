package com.yzu.edu.service;

import com.yzu.edu.mapper.HallMapper;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class HallService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void insertSingle(String siteId, String hallId, String lanId){
        SqlSession session = factory.openSession();
        HallMapper mapper = session.getMapper(HallMapper.class);
        mapper.insertSingle(siteId, hallId, lanId);
        session.commit();
        session.close();
    }

    public void deleteAll(){
        SqlSession session = factory.openSession();
        HallMapper mapper = session.getMapper(HallMapper.class);
        mapper.deleteAll();
        session.commit();
        session.close();
    }
}
