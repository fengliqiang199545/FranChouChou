package cn.com.taiji.service.impl;

import cn.com.taiji.entity.*;
import cn.com.taiji.exception.CustomException;
import cn.com.taiji.mapper.CollegeMapper;
import cn.com.taiji.mapper.CourseMapper;
import cn.com.taiji.mapper.TeacherCustomMapper;
import cn.com.taiji.mapper.TeacherMapper;
import cn.com.taiji.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherCustomMapper teacherCustomMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public void updateById(Integer id, TeacherCustom teacherCustom) throws Exception {
        teacherMapper.updateByPrimaryKey(teacherCustom);
    }

    @Override
    public void removeById(Integer id) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();

        criteria.andTeacheridEqualTo(id);
        List<Course> list = courseMapper.selectByExample(courseExample);

        if (list.size() != 0){
            throw new CustomException("请先删除该老师所教授的所有课程");
        }
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TeacherCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<TeacherCustom> list = teacherCustomMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public Boolean save(TeacherCustom teacherCustom) throws Exception {
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherCustom.getUserid());
        if (teacher == null){
            teacherMapper.insert(teacherCustom);
            return true;
        }
        return false;
    }

    @Override
    public int getCountTeacher() throws Exception {

        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUseridIsNotNull();

        return (int)teacherMapper.countByExample(teacherExample);

    }

    @Override
    public TeacherCustom findById(Integer id) throws Exception {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        TeacherCustom teacherCustom = null;

        if (teacher != null){
            teacherCustom = new TeacherCustom();
            BeanUtils.copyProperties(teacher,teacherCustom);
        }
        return teacherCustom;
    }

    @Override
    public List<TeacherCustom> findByName(String name) throws Exception {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUsernameLike("%" + "%");
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);

        List<TeacherCustom> teacherCustomList = null;

        if (list != null){
            teacherCustomList = new ArrayList<TeacherCustom>();
            for (Teacher t : list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                //类拷贝
                BeanUtils.copyProperties(t, teacherCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(t.getCollegeid());
                teacherCustom.setcollegeName(college.getCollegename());

                teacherCustomList.add(teacherCustom);
            }
        }
        return teacherCustomList;
    }

    @Override
    public List<TeacherCustom> findAll() throws Exception {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();

        criteria.andUsernameIsNotNull();
        List<Teacher> list = teacherMapper.selectByExample(teacherExample);
        List<TeacherCustom> teacherCustomsList = null;
        if (list != null) {
            teacherCustomsList = new ArrayList<TeacherCustom>();
            for (Teacher t: list) {
                TeacherCustom teacherCustom = new TeacherCustom();
                BeanUtils.copyProperties(t, teacherCustom);
                teacherCustomsList.add(teacherCustom);
            }
        }
        return teacherCustomsList;
    }
}
