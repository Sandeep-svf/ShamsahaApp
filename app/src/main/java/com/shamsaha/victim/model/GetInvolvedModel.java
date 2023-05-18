
package com.shamsaha.victim.model;


import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.GetInvolvedRes;


public class GetInvolvedModel {

    @SerializedName("Data")
    private GetInvolvedRes mGetInvolvedRes;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private String mSuccess;

    public GetInvolvedRes getData() {
        return mGetInvolvedRes;
    }

    public void setData(GetInvolvedRes data) {
        mGetInvolvedRes = data;
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
