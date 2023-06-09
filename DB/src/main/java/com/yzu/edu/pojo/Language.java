package com.yzu.edu.pojo;

public class Language {
    private String lanId  ;
    private String lanName;

    public String getLanId() {
        return lanId;
    }

    public void setLanId(String lanId) {
        this.lanId = lanId;
    }

    public String getLanName() {
        return lanName;
    }

    public void setLanName(String lanName) {
        this.lanName = lanName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "lanId='" + lanId + '\'' +
                ", lanName='" + lanName + '\'' +
                '}';
    }
}
