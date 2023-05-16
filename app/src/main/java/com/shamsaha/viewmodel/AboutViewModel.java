package com.shamsaha.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shamsaha.retrofit.API_Client;
import com.shamsaha.retrofit.Api;
import com.shamsaha.victim.model.AboutModel;
import com.shamsaha.victim.model.res.AboutRes;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This is the ViewModel class that handles the data and network requests
 * for the About Activity or Fragment.
 *
 * @author Sandeep Maurya
 * Created on 16/05/2023
 */
public class AboutViewModel extends ViewModel {
    private static final String TAG = "AboutViewModel";
    private final MutableLiveData<String> mutableLiveDataContent = new MutableLiveData<>();
    public LiveData<String> getMutableLiveDataContent() {
        return mutableLiveDataContent;
    }


    public void getContent(){

    }



}
