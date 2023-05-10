
package com.shamsaha.victim.model;
import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.ContactUsDataRes;


public class ContactUsDataModel {

    @SerializedName("Data")
    private ContactUsDataRes mContactUsDataRes;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("success")
    private String mSuccess;

    public ContactUsDataRes getData() {
        return mContactUsDataRes;
    }

    public void setData(ContactUsDataRes contactUsDataRes) {
        mContactUsDataRes = contactUsDataRes;
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
