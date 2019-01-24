package cn.com.taiji.entity;

import java.util.List;

public class StudentCustom extends Student {

    //所属院系名
    private String collegeName;

    //选课列表
    private List<SelectedCourseCustom> selectedCourseList;


    public void setcollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getcollegeName() {
        return collegeName;
    }

    public void setSelectedCourseList(List<SelectedCourseCustom> selectedCourseList) {
        this.selectedCourseList = selectedCourseList;
    }

    public List<SelectedCourseCustom> getSelectedCourseList() {
        return selectedCourseList;
    }

    @Override
    public String toString() {
        return "StudentCustom{" +
                "collegeName='" + collegeName + '\'' +
                ", selectedCourseList=" + selectedCourseList +
                '}';
    }
}
