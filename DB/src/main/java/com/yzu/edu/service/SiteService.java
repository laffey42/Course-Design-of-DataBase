package com.yzu.edu.service;

import com.yzu.edu.mapper.SiteMapper;
import com.yzu.edu.pojo.Site;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SiteService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Site> selectAll() {
        SqlSession session = factory.openSession();
        SiteMapper mapper = session.getMapper(SiteMapper.class);
        List<Site> sites = mapper.selectAll();
        session.close();
        return sites;
    }

    public Site selectSingle(String siteId) {
        SqlSession session = factory.openSession();
        SiteMapper mapper = session.getMapper(SiteMapper.class);
        Site site = mapper.selectSingle(siteId);
        session.close();
        return site;
    }

    public void updateSingle(String siteId, String siteName, String originId) {
        SqlSession session = factory.openSession();
        SiteMapper mapper = session.getMapper(SiteMapper.class);
        mapper.updateSingle(siteId, siteName, originId);
        session.commit();
        session.close();
    }
}
