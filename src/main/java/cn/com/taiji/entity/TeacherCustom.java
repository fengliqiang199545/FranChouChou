package cn.com.taiji.entity;

public class TeacherCustom extends Teacher {
    //所属院系名
    private String collegeName;

    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getcollegeName() {
        return collegeName;
    }

    @Override
    public String toString() {
        return "TeacherCustom{" +
                "collegeName='" + collegeName + '\'' +
                '}';
    }
}
