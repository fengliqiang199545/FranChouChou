package cn.com.taiji.service.impl;

import cn.com.taiji.entity.Student;
import cn.com.taiji.entity.Userlogin;
import cn.com.taiji.entity.UserloginExample;
import cn.com.taiji.mapper.StudentMapper;
import cn.com.taiji.mapper.UserloginMapper;
import cn.com.taiji.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserloginServiceImpl implements UserloginService {

    @Autowired
    private UserloginMapper userloginMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Userlogin findByName(String name) throws Exception {
        UserloginExample userloginExample = new UserloginExample();



        UserloginExample.Criteria criteria = userloginExample.createCriteria();

            criteria.andUsernameEqualTo(name);

        //criteria.andUseridEqualTo(Integer.parseInt(name));

        List<Userlogin> list = userloginMapper.selectByExample(userloginExample);




            return list.get(0);






    }

    @Override
    public void save(Userlogin userlogin) throws Exception {

        userloginMapper.insertSelective(userlogin);
    }

    @Override
    public void removeByName(String name) throws Exception {

        UserloginExample userloginExample = new UserloginExample();
        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.deleteByExample(userloginExample);
    }

    @Override
    public void updateByName(String name, Userlogin userlogin) {
        UserloginExample userloginExample = new UserloginExample();

        UserloginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.updateByExample(userlogin, userloginExample);
    }
}
