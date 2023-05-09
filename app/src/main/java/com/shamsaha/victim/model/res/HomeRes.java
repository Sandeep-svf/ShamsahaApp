package com.shamsaha.victim.model.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeRes {

@SerializedName("image")
@Expose
public String image;
@SerializedName("heading1")
@Expose
public String heading1;
@SerializedName("content1")
@Expose
public String content1;
@SerializedName("heading2")
@Expose
public String heading2;
@SerializedName("content2")
@Expose
public String content2;

    public String getImage() {
        return image;
    }

    public String getHeading1() {
        return heading1;
    }

    public String getContent1() {
        return content1;
    }

    public String getHeading2() {
        return heading2;
    }

    public String getContent2() {
        return content2;
    }
}