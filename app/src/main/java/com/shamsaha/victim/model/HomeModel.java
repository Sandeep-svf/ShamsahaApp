package com.shamsaha.victim.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.HomeRes;

public class HomeModel {

@SerializedName("success")
@Expose
public String success;
@SerializedName("message")
@Expose
public String message;
@SerializedName("Data")
@Expose
public HomeRes homeRes;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public HomeRes getData() {
        return homeRes;
    }
}