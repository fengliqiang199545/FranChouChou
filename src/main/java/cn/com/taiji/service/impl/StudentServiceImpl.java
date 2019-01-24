package cn.com.taiji.service.impl;

import cn.com.taiji.entity.*;
import cn.com.taiji.mapper.CollegeMapper;
import cn.com.taiji.mapper.StudentCustomMapper;
import cn.com.taiji.mapper.StudentMapper;
import cn.com.taiji.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //spring自动注入
    @Autowired
    private StudentCustomMapper studentCustomMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CollegeMapper collegeMapper;


    @Override
    public void updataById(Integer id, StudentCustom studentCustom) throws Exception {
        studentMapper.updateByPrimaryKey(studentCustom);
    }

    @Override
    public void removeById(Integer id) throws Exception {
            studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StudentCustom> findByPaging(Integer toPageNo) throws Exception {
        PagingVO pagingVO = new PagingVO();
        pagingVO.setToPageNo(toPageNo);

        List<StudentCustom> list = studentCustomMapper.findByPaging(pagingVO);
        return list;
    }

    @Override
    public Boolean save(StudentCustom studentCustoms) throws Exception {

        Student student = studentMapper.selectByPrimaryKey(studentCustoms.getUserid());

        if(student == null){
            studentMapper.insert(studentCustoms);
            return true;
        }
        return false;
    }

    @Override
    public int getCountStudent() throws Exception {
        //自定义查询对象
        StudentExample studentExample = new StudentExample();

        //通过criteria构造查询条件
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUseridIsNotNull();

        return (int)studentMapper.countByExample(studentExample);

    }

    @Override
    public StudentCustom findById(Integer id) throws Exception {
        StudentCustom studentCustom= null;

        Student student = studentMapper.selectByPrimaryKey(id);
        if(student != null){
            studentCustom  = new StudentCustom();

            //类的拷贝
            BeanUtils.copyProperties(student,studentCustom);
        }
        return studentCustom;
    }

    //模糊查询
    @Override
    public List<StudentCustom> findByName(String name) throws Exception {
        StudentExample studentExample = new StudentExample();

        //自定义查询条件
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUsernameLike("%" + name + "%");

        List<Student> list = studentMapper.selectByExample(studentExample);

        List<StudentCustom> studentCustomList = null;

        if(list != null){
            studentCustomList = new ArrayList<StudentCustom>();
            for (Student s :list
                 ) {
                StudentCustom  studentCustom = new StudentCustom();
                //进行类拷贝
                BeanUtils.copyProperties(s,studentCustom);
                //获取课程名
                College college = collegeMapper.selectByPrimaryKey(s.getCollegeid());
                studentCustom.setcollegeName(college.getCollegename());

                studentCustomList.add(studentCustom);
            }
        }
        return studentCustomList;
    }

    @Override
    public StudentCustom findStudentAndSelectCourseListByName(String name) throws Exception {

        StudentCustom studentCustom = studentCustomMapper.findStudentAndSelectCourseListById(Integer.parseInt(name));

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        //判断该课程是否修完
        for (SelectedCourseCustom s:list
             ) {
            if (s.getMark() != null){
                s.setOver(true);
            }
        }
        return studentCustom;
    }
}
