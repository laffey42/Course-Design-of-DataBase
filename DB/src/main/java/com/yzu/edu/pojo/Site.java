package com.yzu.edu.pojo;

public class Site {
    private String siteId;
    private String siteName;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public String toString() {
        return "Site{" +
                "siteId='" + siteId + '\'' +
                ", siteName='" + siteName + '\'' +
                '}';
    }
}
