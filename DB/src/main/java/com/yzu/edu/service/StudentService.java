package com.yzu.edu.service;

import com.yzu.edu.mapper.StudentMapper;
import com.yzu.edu.pojo.Info;
import com.yzu.edu.pojo.Student;
import com.yzu.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StudentService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Student> selectAll(){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        session.close();
        return students;
    }

    public List<Student> selectAllInLanId(String lanId){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAllByLanId(lanId);
        session.close();
        return students;
    }

    public Student selectSingle(String stuId){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.selectSingle(stuId);
        session.close();
        return student;
    }

    public void insertSingle(String stuId, String stuName, String lanId){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.insertSingle(stuId, stuName, lanId);
        session.commit();
        session.close();
    }

    public void updateSingle(String stuId, String stuName, String lanId, String originId){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.updateSingle(stuId, stuName, lanId, originId);
        session.commit();
        session.close();
    }

    public void deleteSingle(String stuId){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.deleteSingle(stuId);
        session.commit();
        session.close();
    }

    public void deleteAll(){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.deleteAll();
        session.commit();
        session.close();
    }

    public List<Integer> selectNumPerLan(){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Integer> nums = mapper.selectNumPerLan();
        session.close();
        return nums;
    }

    public List<String> selectAllLanId(){
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<String> ids = mapper.selectAllLanId();
        session.close();
        return ids;
    }
}
