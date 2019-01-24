package cn.com.taiji.mapper;

import cn.com.taiji.entity.PagingVO;
import cn.com.taiji.entity.StudentCustom;

import java.util.List;

public interface StudentCustomMapper {

    //分页查询学生信息
    List<StudentCustom> findByPaging(PagingVO pagingVO)throws Exception;

    //查询学生信息和其选课信息
    StudentCustom findStudentAndSelectCourseListById(Integer id)throws Exception;
}
