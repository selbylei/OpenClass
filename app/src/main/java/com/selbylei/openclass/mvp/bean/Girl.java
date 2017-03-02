package com.selbylei.openclass.mvp.bean;

/**
 * Created by selbylei on 17/2/17.
 */
public class Girl {

    private int ResId;
    private String start;
    private String description;

    public Girl(int resId, String start, String description) {
        ResId = resId;
        this.start = start;
        this.description = description;
    }

    public int getResId() {
        return ResId;
    }

    public void setResId(int resId) {
        ResId = resId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
