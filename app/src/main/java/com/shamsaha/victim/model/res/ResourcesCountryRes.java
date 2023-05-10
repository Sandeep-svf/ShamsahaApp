
package com.shamsaha.victim.model.res;


import com.google.gson.annotations.SerializedName;



public class ResourcesCountryRes {

    @SerializedName("location_name")
    private String mLocationName;
    @SerializedName("wcrid")
    private String mWcrid;

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String locationName) {
        mLocationName = locationName;
    }

    public String getWcrid() {
        return mWcrid;
    }

    public void setWcrid(String wcrid) {
        mWcrid = wcrid;
    }

}
