
package com.shamsaha.victim.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.ResourcesCaregoryRes;


@SuppressWarnings("unused")
public class ResourceCategoryModel {

    @SerializedName("Data")
    private List<ResourcesCaregoryRes> mData;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private String mSuccess;

    public List<ResourcesCaregoryRes> getData() {
        return mData;
    }

    public void setData(List<ResourcesCaregoryRes> data) {
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
