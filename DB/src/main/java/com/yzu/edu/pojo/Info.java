package com.yzu.edu.pojo;

public class Info {
    private String admission;
    private String time;
    private String stuId;
    private String siteId;
    private String hallId;
    private String seat;

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
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
        return "Info{" +
                "admission='" + admission + '\'' +
                ", time='" + time + '\'' +
                ", stuId='" + stuId + '\'' +
                ", siteId='" + siteId + '\'' +
                ", hallId='" + hallId + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
