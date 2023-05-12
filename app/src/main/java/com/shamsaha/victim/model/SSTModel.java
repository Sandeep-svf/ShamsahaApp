
package com.shamsaha.victim.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.SSTRes;


public class SSTModel {

    @SerializedName("data")
    private List<SSTRes> mData;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<SSTRes> getData() {
        return mData;
    }

    public void setData(List<SSTRes> data) {
        mData = data;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}
