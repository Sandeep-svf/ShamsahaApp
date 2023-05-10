
package com.shamsaha.victim.model.res;
import com.google.gson.annotations.SerializedName;


public class ContactUsDataRes {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("content")
    private String mContent;
    @SerializedName("google_map")
    private String mGoogleMap;
    @SerializedName("heading")
    private String mHeading;
    @SerializedName("image")
    private String mImage;
    @SerializedName("latitude")
    private String mLatitude;
    @SerializedName("longitude")
    private String mLongitude;
    @SerializedName("title")
    private String mTitle;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getGoogleMap() {
        return mGoogleMap;
    }

    public void setGoogleMap(String googleMap) {
        mGoogleMap = googleMap;
    }

    public String getHeading() {
        return mHeading;
    }

    public void setHeading(String heading) {
        mHeading = heading;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
