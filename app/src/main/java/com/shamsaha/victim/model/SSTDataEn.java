
package com.shamsaha.victim.model;


import com.google.gson.annotations.SerializedName;


public class SSTDataEn {

    @SerializedName("name")
    private String mName;
    @SerializedName("path")
    private String mPath;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

}
