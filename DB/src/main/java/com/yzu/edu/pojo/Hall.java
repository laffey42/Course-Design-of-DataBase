package com.yzu.edu.pojo;

public class Hall {
    private String siteId;
    private String hallId;
    private String lanId;

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

    @Override
    public String toString() {
        return "Hall{" +
                "siteId='" + siteId + '\'' +
                ", hallId='" + hallId + '\'' +
                ", lanId='" + lanId + '\'' +
                '}';
    }
}
