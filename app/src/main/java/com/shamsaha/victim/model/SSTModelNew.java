
package com.shamsaha.victim.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class SSTModelNew {

    @SerializedName("data_ar")
    private List<SSTDataAr> mSSTDataAr;
    @SerializedName("data_en")
    private List<SSTDataEn> mSSTDataEn;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private Boolean mStatus;

    public List<SSTDataAr> getDataAr() {
        return mSSTDataAr;
    }

    public void setDataAr(List<SSTDataAr> SSTDataAr) {
        mSSTDataAr = SSTDataAr;
    }

    public List<SSTDataEn> getDataEn() {
        return mSSTDataEn;
    }

    public void setDataEn(List<SSTDataEn> SSTDataEn) {
        mSSTDataEn = SSTDataEn;
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
