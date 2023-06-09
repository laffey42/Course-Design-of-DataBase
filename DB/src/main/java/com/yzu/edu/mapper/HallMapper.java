package com.yzu.edu.mapper;

import org.apache.ibatis.annotations.Param;

public interface HallMapper {

    void insertSingle(@Param("siteId") String siteId, @Param("hallId") String hallId, @Param("lanId") String lanId);

    void deleteAll();

}
