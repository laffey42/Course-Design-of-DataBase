package com.yzu.edu.service;

import com.yzu.edu.mapper.InfoMapper;
import com.yzu.edu.mapper.InfoViewMapper;
import com.yzu.edu.pojo.Info;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import com.yzu.edu.view.InfoView;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class InfoService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Info> selectAll(){
        SqlSession session = factory.openSession();
        InfoMapper mapper = session.getMapper(InfoMapper.class);
        List<Info> infos = mapper.selectAll();
        session.close();
        return infos;
    }

    public Info selectSingle(String admission){
        SqlSession session = factory.openSession();
        InfoMapper mapper = session.getMapper(InfoMapper.class);
        Info info = mapper.selectSingle(admission);
        session.close();
        return info;
    }

    public List<InfoView> viewAll(){
        SqlSession session = factory.openSession();
        InfoViewMapper mapper = session.getMapper(InfoViewMapper.class);
        List<InfoView> infoViews = mapper.selectAll();
        session.close();
        return infoViews;
    }

    public InfoView viewSingle(String admission, String stuId){
        SqlSession session = factory.openSession();
        InfoViewMapper mapper = session.getMapper(InfoViewMapper.class);
        InfoView infoView = mapper.selectSingle(admission, stuId);
        session.close();
        return infoView;
    }

    public void insertSingle(String admission, String time, String stuId, String siteId, String hallId, String seat){
        SqlSession session = factory.openSession();
        InfoMapper mapper = session.getMapper(InfoMapper.class);
        mapper.insertSingle(admission, time, stuId, siteId, hallId, seat);
        session.commit();
        session.close();
    }

    public void deleteAll(){
        SqlSession session = factory.openSession();
        InfoMapper mapper = session.getMapper(InfoMapper.class);
        mapper.deleteAll();
        session.commit();
        session.close();
    }
}
