package cn.com.taiji.entity;

public class Userlogin extends UserloginKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userlogin.userName
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userlogin.password
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userlogin.userName
     *
     * @return the value of userlogin.userName
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userlogin.userName
     *
     * @param username the value for userlogin.userName
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userlogin.password
     *
     * @return the value of userlogin.password
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userlogin.password
     *
     * @param password the value for userlogin.password
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}