package cn.com.taiji.service;

import cn.com.taiji.entity.Role;

/**
 *  Role 权限表Service层
 */
public interface RoleService {

    Role findByid(Integer id) throws Exception;

}
