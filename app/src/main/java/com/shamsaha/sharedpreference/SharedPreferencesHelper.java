package com.shamsaha.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    private static final String PREF_NAME = "MyPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String VICTIM_MOBILE_WIZARD_FLAG = "victimmobileflag";

    private SharedPreferences sharedPreferences;

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setUsername(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public void setVicitmMobileWizardFlag(String flag){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(VICTIM_MOBILE_WIZARD_FLAG,flag);
        editor.apply();
    }

    public String getVicitmMobileWizardFlag(){
       return sharedPreferences.getString(VICTIM_MOBILE_WIZARD_FLAG,null);
    }

    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, null);
    }
}
