package com.yzu.edu.mapper;

import com.yzu.edu.pojo.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {

    List<Score> selectAll();

    Score selectSingle(String admission);

    void insertSingle(
            @Param("admission") String admission,
            @Param("score01") int score01,
            @Param("score02") int score02,
            @Param("scoreTotal") int scoreTotal
    );

    void updateSingle(
            @Param("admission") String admission,
            @Param("score01") int score01,
            @Param("score02") int score02,
            @Param("scoreTotal") int scoreTotal
    );

    void deleteAll();

}
