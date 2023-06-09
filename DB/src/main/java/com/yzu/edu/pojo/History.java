package com.yzu.edu.pojo;

public class History {
    private String stuId;
    private String time;
    private String siteId;
    private String hallId;
    private String lanId;
    private int score01;
    private int score02;
    private int scoreTotal;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getLanId() {
        return lanId;
    }

    public void setLanId(String lanId) {
        this.lanId = lanId;
    }

    public int getScore01() {
        return score01;
    }

    public void setScore01(int score01) {
        this.score01 = score01;
    }

    public int getScore02() {
        return score02;
    }

    public void setScore02(int score02) {
        this.score02 = score02;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    @Override
    public String toString() {
        return "History{" +
                "stuId='" + stuId + '\'' +
                ", time='" + time + '\'' +
                ", siteId='" + siteId + '\'' +
                ", hallId='" + hallId + '\'' +
                ", lanId='" + lanId + '\'' +
                ", score01=" + score01 +
                ", score02=" + score02 +
                ", scoreTotal=" + scoreTotal +
                '}';
    }
}
