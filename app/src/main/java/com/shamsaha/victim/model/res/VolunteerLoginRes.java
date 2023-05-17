
package com.shamsaha.victim.model.res;


import com.google.gson.annotations.SerializedName;


public class VolunteerLoginRes {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("dob")
    private String mDob;
    @SerializedName("doj")
    private String mDoj;
    @SerializedName("gender")
    private String mGender;
    @SerializedName("language_known")
    private String mLanguageKnown;
    @SerializedName("password_login_first")
    private String mPasswordLoginFirst;
    @SerializedName("profile_pic")
    private String mProfilePic;
    @SerializedName("shift_language")
    private String mShiftLanguage;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("total_rewards")
    private String mTotalRewards;
    @SerializedName("vemail")
    private String mVemail;
    @SerializedName("vmobile")
    private String mVmobile;
    @SerializedName("vname")
    private String mVname;
    @SerializedName("vounter_id")
    private String mVounterId;
    @SerializedName("wc_vid")
    private String mWcVid;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getDob() {
        return mDob;
    }

    public void setDob(String dob) {
        mDob = dob;
    }

    public String getDoj() {
        return mDoj;
    }

    public void setDoj(String doj) {
        mDoj = doj;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    public String getLanguageKnown() {
        return mLanguageKnown;
    }

    public void setLanguageKnown(String languageKnown) {
        mLanguageKnown = languageKnown;
    }

    public String getPasswordLoginFirst() {
        return mPasswordLoginFirst;
    }

    public void setPasswordLoginFirst(String passwordLoginFirst) {
        mPasswordLoginFirst = passwordLoginFirst;
    }

    public String getProfilePic() {
        return mProfilePic;
    }

    public void setProfilePic(String profilePic) {
        mProfilePic = profilePic;
    }

    public String getShiftLanguage() {
        return mShiftLanguage;
    }

    public void setShiftLanguage(String shiftLanguage) {
        mShiftLanguage = shiftLanguage;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTotalRewards() {
        return mTotalRewards;
    }

    public void setTotalRewards(String totalRewards) {
        mTotalRewards = totalRewards;
    }

    public String getVemail() {
        return mVemail;
    }

    public void setVemail(String vemail) {
        mVemail = vemail;
    }

    public String getVmobile() {
        return mVmobile;
    }

    public void setVmobile(String vmobile) {
        mVmobile = vmobile;
    }

    public String getVname() {
        return mVname;
    }

    public void setVname(String vname) {
        mVname = vname;
    }

    public String getVounterId() {
        return mVounterId;
    }

    public void setVounterId(String vounterId) {
        mVounterId = vounterId;
    }

    public String getWcVid() {
        return mWcVid;
    }

    public void setWcVid(String wcVid) {
        mWcVid = wcVid;
    }

}
