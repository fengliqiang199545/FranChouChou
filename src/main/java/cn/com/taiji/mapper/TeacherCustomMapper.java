package cn.com.taiji.mapper;

import cn.com.taiji.entity.PagingVO;
import cn.com.taiji.entity.TeacherCustom;

import java.util.List;

public interface TeacherCustomMapper {
    //分页查询老师信息
    List<TeacherCustom> findByPaging(PagingVO pagingVO) throws Exception;
}
