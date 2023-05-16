package com.shamsaha.victim.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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
