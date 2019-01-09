package cn.com.taiji.entity;

import java.util.Date;

public class Teacher {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.userID
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.userName
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.sex
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.birthYear
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private Date birthyear;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.degree
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private String degree;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.title
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.grade
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private Date grade;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.collegeID
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    private Integer collegeid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.userID
     *
     * @return the value of teacher.userID
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.userID
     *
     * @param userid the value for teacher.userID
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.userName
     *
     * @return the value of teacher.userName
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.userName
     *
     * @param username the value for teacher.userName
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.sex
     *
     * @return the value of teacher.sex
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.sex
     *
     * @param sex the value for teacher.sex
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.birthYear
     *
     * @return the value of teacher.birthYear
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public Date getBirthyear() {
        return birthyear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.birthYear
     *
     * @param birthyear the value for teacher.birthYear
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setBirthyear(Date birthyear) {
        this.birthyear = birthyear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.degree
     *
     * @return the value of teacher.degree
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public String getDegree() {
        return degree;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.degree
     *
     * @param degree the value for teacher.degree
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.title
     *
     * @return the value of teacher.title
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.title
     *
     * @param title the value for teacher.title
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.grade
     *
     * @return the value of teacher.grade
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public Date getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.grade
     *
     * @param grade the value for teacher.grade
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setGrade(Date grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.collegeID
     *
     * @return the value of teacher.collegeID
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.collegeID
     *
     * @param collegeid the value for teacher.collegeID
     *
     * @mbg.generated Wed Jan 09 11:47:48 CST 2019
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }
}