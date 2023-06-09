package com.yzu.edu.mapper;

import com.yzu.edu.view.InfoView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoViewMapper {

    List<InfoView> selectAll();

    InfoView selectSingle(@Param("admission") String admission, @Param("stuId") String stuId);

}
