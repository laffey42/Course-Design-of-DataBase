package com.yzu.edu.mapper;

import com.yzu.edu.pojo.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryMapper {

    List<History> selectAll();

    void insertSingle(
            @Param("stuId") String stuId,
            @Param("time") String time,
            @Param("siteId") String siteId,
            @Param("hallId") String hallId,
            @Param("lanId") String lanId,
            @Param("score01") int score01,
            @Param("score02") int score02,
            @Param("scoreTotal") int scoreTotal
    );

}
