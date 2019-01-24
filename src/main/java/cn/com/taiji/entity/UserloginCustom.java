package cn.com.taiji.entity;

public class UserloginCustom extends Userlogin {


    private Role role_ob;

    public void setRole(Role role) {
        this.role_ob = role_ob;
    }

    public Role getRole_ob() {
        return role_ob;
    }

    @Override
    public String toString() {
        return "UserloginCustom{" +
                "role_ob=" + role_ob +
                '}';
    }
}
