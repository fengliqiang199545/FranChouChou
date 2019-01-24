package cn.com.taiji.realm;

import cn.com.taiji.entity.Role;
import cn.com.taiji.entity.Userlogin;
import cn.com.taiji.service.RoleService;
import cn.com.taiji.service.UserloginService;
import cn.com.taiji.service.impl.UserloginServiceImpl;
import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm {

    @Resource(name = "userloginServiceImpl")
    private UserloginService userloginService;

    @Resource(name = "roleServiceImpl")
    private RoleService roleService;

    /**
     *      进行权限的分配
     * **/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String name = (String)getAvailablePrincipal(principals);

        Role role = null;

        try {
            Userlogin userlogin = userloginService.findByName(name);
            //获取角色对象
            role = roleService.findByid(userlogin.getRole());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //通过用户名从数据库获取角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> strings = new HashSet<String>();

        if (role != null){
            strings.add(role.getRolename());
            info.setRoles(strings);
        }

        return info;
    }


    /**
     *      身份验证
     * **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());

        Userlogin userlogin = null;

        try {
            userlogin = userloginService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (userlogin == null){
            throw new UnknownAccountException();
        }else if (!password.equals(userlogin.getPassword())){
            throw new IncorrectCredentialsException();
        }

        //否则身份验证通过
        AuthenticationInfo info = new SimpleAuthenticationInfo(username,password,getName());
        return info;
    }
}
