
package com.shamsaha.victim.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.EventVolunteerRes;


public class EventVolunteerModel {

    @SerializedName("Data")
    private List<EventVolunteerRes> mData;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private String mSuccess;

    public List<EventVolunteerRes> getData() {
        return mData;
    }

    public void setData(List<EventVolunteerRes> data) {
        mData = data;
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
