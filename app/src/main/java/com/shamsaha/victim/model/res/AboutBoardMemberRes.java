
package com.shamsaha.victim.model.res;


import com.google.gson.annotations.SerializedName;


public class AboutBoardMemberRes {

    @SerializedName("name")
    private String mBname;
    @SerializedName("designation")
    private String mDesignation;
    @SerializedName("image")
    private String mImage;

    public String getBname() {
        return mBname;
    }

    public void setBname(String bname) {
        mBname = bname;
    }

    public String getDesignation() {
        return mDesignation;
    }

    public void setDesignation(String designation) {
        mDesignation = designation;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

}
