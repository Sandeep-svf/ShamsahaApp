
package com.shamsaha.victim.model;

import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.AboutRes;


public class AboutModel {

    @SerializedName("Data")
    private AboutRes mAboutRes;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private String mSuccess;

    public AboutRes getData() {
        return mAboutRes;
    }

    public void setData(AboutRes aboutRes) {
        mAboutRes = aboutRes;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getSuccess() {
        return mSuccess;
    }

    public void setSuccess(String success) {
        mSuccess = success;
    }

}
