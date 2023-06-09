package com.yzu.edu.mapper;

import com.yzu.edu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> selectAll();

    List<Student> selectAllByLanId(String lanId);

    Student selectSingle(String stuId);

    void insertSingle(@Param("stuId") String stuId, @Param("stuName") String stuName, @Param("lanId") String lanId);

    void updateSingle(@Param("stuId") String stuId, @Param("stuName") String stuName, @Param("lanId") String lanId, @Param("originId") String originId);

    void deleteSingle(String stuId);

    void deleteAll();

    List<Integer> selectNumPerLan();

    List<String> selectAllLanId();
}
