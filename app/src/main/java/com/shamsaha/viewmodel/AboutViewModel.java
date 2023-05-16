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
        Api api = API_Client.getClient().create(api.class);
        Call<AboutModel> aboutCall = api.ABOUT_MODEL_CALL();

        aboutCall.enqueue(new Callback<AboutModel>() {
            @Override
            public void onResponse(@NotNull Call<AboutModel> call, @NotNull Response<AboutModel> response) {
                if (response.isSuccessful() && response.body()!= null){
                   AboutModel dataAbout = response.body();
                   /* for (AboutModel about : dataAbout){
                        if (baseURL.LANGUAGE_CODE.equalsIgnoreCase("en")) {
                            mutableLiveDataContent.postValue(about.getContentEn());
                        }else {
                            mutableLiveDataContent.postValue(about.getContentAr());
                        }
                    }*/
                    AboutRes aboutRes = dataAbout.getData();

                }
            }

            @Override
            public void onFailure(Call<AboutModel> call, Throwable t) {

            }


        });
    }



}
