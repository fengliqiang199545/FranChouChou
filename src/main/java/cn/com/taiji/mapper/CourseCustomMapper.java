package cn.com.taiji.mapper;

import cn.com.taiji.entity.CourseCustom;
import cn.com.taiji.entity.PagingVO;

import java.util.List;

public interface CourseCustomMapper {

    //分页查询学生信息
    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;
}
