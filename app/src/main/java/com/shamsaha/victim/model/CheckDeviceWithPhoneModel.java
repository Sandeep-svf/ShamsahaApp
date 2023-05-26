
package com.shamsaha.victim.model;


import com.google.gson.annotations.SerializedName;


public class CheckDeviceWithPhoneModel {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private String mSuccess;

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
