package com.yzu.edu.view;

public class InfoView {
    private String admission;
    private String stuName;
    private String time;
    private String lanName;
    private String siteName;
    private String hallId;
    private String seat;

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLanName() {
        return lanName;
    }

    public void setLanName(String lanName) {
        this.lanName = lanName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "InfoView{" +
                "admission='" + admission + '\'' +
                ", stuName='" + stuName + '\'' +
                ", time='" + time + '\'' +
                ", lanName='" + lanName + '\'' +
                ", siteName='" + siteName + '\'' +
                ", hallId='" + hallId + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
