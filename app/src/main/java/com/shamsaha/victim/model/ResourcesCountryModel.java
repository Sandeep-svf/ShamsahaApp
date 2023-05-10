
package com.shamsaha.victim.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.ResourcesCountryRes;


@SuppressWarnings("unused")
public class ResourcesCountryModel {

    @SerializedName("Data")
    private List<ResourcesCountryRes> mData;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private String mSuccess;

    public List<ResourcesCountryRes> getData() {
        return mData;
    }

    public void setData(List<ResourcesCountryRes> data) {
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
