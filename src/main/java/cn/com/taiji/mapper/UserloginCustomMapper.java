package cn.com.taiji.mapper;

import cn.com.taiji.entity.UserloginCustom;

public interface UserloginCustomMapper {

    //通过名称查找登录信息
    UserloginCustom findByName(String name)throws Exception;


}
