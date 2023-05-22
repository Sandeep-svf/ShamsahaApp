
package com.shamsaha.victim.model.res;


import com.google.gson.annotations.SerializedName;


public class MediaPhotoRes {

    @SerializedName("event_id")
    private String mEventId;
    @SerializedName("media_id")
    private String mMediaId;
    @SerializedName("media_image")
    private String mMediaImage;

    public String getEventId() {
        return mEventId;
    }

    public void setEventId(String eventId) {
        mEventId = eventId;
    }

    public String getMediaId() {
        return mMediaId;
    }

    public void setMediaId(String mediaId) {
        mMediaId = mediaId;
    }

    public String getMediaImage() {
        return mMediaImage;
    }

    public void setMediaImage(String mediaImage) {
        mMediaImage = mediaImage;
    }

}
