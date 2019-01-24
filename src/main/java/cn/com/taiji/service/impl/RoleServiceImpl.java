package cn.com.taiji.service.impl;

import cn.com.taiji.entity.Role;
import cn.com.taiji.mapper.RoleMapper;
import cn.com.taiji.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findByid(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }
}
