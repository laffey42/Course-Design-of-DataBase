package com.yzu.edu.service;

import com.yzu.edu.mapper.ScoreMapper;
import com.yzu.edu.pojo.Score;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ScoreService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Score> selectAll(){
        SqlSession session = factory.openSession();
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);
        List<Score> scores = mapper.selectAll();
        session.close();
        return scores;
    }

    public Score selectSingle(String admission){
        SqlSession session = factory.openSession();
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);
        Score score = mapper.selectSingle(admission);
        session.close();
        return score;
    }

    public void insertSingle(String admission, int score01, int score02, int scoreTotal){
        SqlSession session = factory.openSession();
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);
        mapper.insertSingle(admission, score01, score02, scoreTotal);
        session.commit();
        session.close();
    }

    public void updateSingle(String admission, int score01, int score02, int scoreTotal){
        SqlSession session = factory.openSession();
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);
        mapper.updateSingle(admission, score01, score02, scoreTotal);
        session.commit();
        session.close();
    }


    public void deleteAll(){
        SqlSession session = factory.openSession();
        ScoreMapper mapper = session.getMapper(ScoreMapper.class);
        mapper.deleteAll();
        session.commit();
        session.close();
    }
}
