package com.yzu.edu.mapper;

import com.yzu.edu.pojo.Site;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteMapper {

    List<Site> selectAll();

    Site selectSingle(String siteId);

    void updateSingle(
            @Param("siteId") String siteId,
            @Param("siteName") String siteName,
            @Param("originId") String originId
    );

}

