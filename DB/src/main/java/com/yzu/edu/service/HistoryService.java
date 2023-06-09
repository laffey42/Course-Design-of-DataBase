package com.yzu.edu.service;

import com.yzu.edu.mapper.HistoryMapper;
import com.yzu.edu.pojo.History;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class HistoryService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<History> selectAll(){
        SqlSession session = factory.openSession();
        HistoryMapper mapper = session.getMapper(HistoryMapper.class);
        List<History> histories = mapper.selectAll();
        session.close();
        return histories;
    }

    public void insertSingle(
            String stuId,
            String time,
            String siteId,
            String hallId,
            String lanId,
            int score01,
            int score02,
            int scoreTotal) {
        SqlSession session = factory.openSession();
        HistoryMapper mapper = session.getMapper(HistoryMapper.class);
        mapper.insertSingle(stuId, time, siteId, hallId, lanId, score01, score02, scoreTotal);
        session.commit();
        session.close();
    }
}
