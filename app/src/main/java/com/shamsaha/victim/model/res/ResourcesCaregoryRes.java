
package com.shamsaha.victim.model.res;


import com.google.gson.annotations.SerializedName;


public class ResourcesCaregoryRes {

    @SerializedName("category_icon")
    private String mCategoryIcon;
    @SerializedName("category_name")
    private String mCategoryName;
    @SerializedName("location_name")
    private String mLocationName;
    @SerializedName("wcrcid")
    private String mWcrcid;
    @SerializedName("wcrid")
    private String mWcrid;

    public String getCategoryIcon() {
        return mCategoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        mCategoryIcon = categoryIcon;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String locationName) {
        mLocationName = locationName;
    }

    public String getWcrcid() {
        return mWcrcid;
    }

    public void setWcrcid(String wcrcid) {
        mWcrcid = wcrcid;
    }

    public String getWcrid() {
        return mWcrid;
    }

    public void setWcrid(String wcrid) {
        mWcrid = wcrid;
    }

}
