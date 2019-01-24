package cn.com.taiji.service.impl;

import cn.com.taiji.entity.College;
import cn.com.taiji.entity.CollegeExample;
import cn.com.taiji.mapper.CollegeMapper;
import cn.com.taiji.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> finAll() throws Exception {
        CollegeExample collegeExample = new CollegeExample();

        CollegeExample.Criteria criteria = collegeExample.createCriteria();

        criteria.andCollegeidIsNotNull();

        return collegeMapper.selectByExample(collegeExample);

    }
}
