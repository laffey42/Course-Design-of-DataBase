package com.yzu.edu.mapper;

import com.yzu.edu.pojo.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {

    List<Info> selectAll();

    Info selectSingle(String admission);

    void insertSingle(
            @Param("admission") String admission,
            @Param("time") String time,
            @Param("stuId") String stuId,
            @Param("siteId") String siteId,
            @Param("hallId") String hallId,
            @Param("seat") String seat
    );

    void deleteAll();

}
