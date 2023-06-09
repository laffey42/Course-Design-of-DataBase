package com.yzu.edu.pojo;

public class Score {
    private String admission;
    private int score01;
    private int score02;
    private int scoreTotal;

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
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
        return "Score{" +
                "admission='" + admission + '\'' +
                ", score01=" + score01 +
                ", score02=" + score02 +
                ", scoreTotal=" + scoreTotal +
                '}';
    }
}
