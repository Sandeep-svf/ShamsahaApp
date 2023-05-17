package com.shamsaha.victim.viewmodel;

import com.google.gson.annotations.SerializedName;
import com.shamsaha.victim.model.res.AboutRes;

public class VolunteerLoginBody {
    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



