package com.shamsaha.victim.viewmodel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.shamsaha.retrofit.API_Client;
import com.shamsaha.retrofit.Api;
import com.shamsaha.victim.model.MediaArticleModel;
import com.shamsaha.victim.model.MediaPhotoModel;
import org.json.JSONObject;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is the ViewModel class that handles the data and network requests
 * for the Activity or Fragment.
 *
 * @author Sandeep Maurya
 * Created on 16/05/2023
 */

public class MediaArticleViewModel extends ViewModel {
    private MutableLiveData<MediaArticleModel> articleModelMutableLiveData;

    public LiveData<MediaArticleModel> getMediaArticleList(String language, Context activity){
        if(articleModelMutableLiveData == null){
            articleModelMutableLiveData = new MutableLiveData<>();
            load_media_article_list(language,activity);
        }
        return articleModelMutableLiveData;
    }

    private void load_media_article_list(String language, Context activity) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_Client.BASE_URL) // Replace with your API base URL
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Api apiService = retrofit.create(Api.class);

            Call<MediaArticleModel> call = apiService.MEDIA_ARTICLE_MODEL_CALL("en");
            call.enqueue(new Callback<MediaArticleModel>() {
                @Override
                public void onResponse(Call<MediaArticleModel> call, Response<MediaArticleModel> response) {
                    if (response.isSuccessful()) {

                        MediaArticleModel mediaArticleModel = response.body();
                        articleModelMutableLiveData.setValue(mediaArticleModel);

                    } else {
                        try {
                            JSONObject jObjError = new JSONObject(response.errorBody().string());

                            Toast.makeText(activity, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                            switch (response.code()) {
                                case 400:
                                    Toast.makeText(activity, "The server did not understand the request.", Toast.LENGTH_SHORT).show();
                                    break;
                                case 401:
                                    Toast.makeText(activity, "Unauthorized The requested page needs a username and a password.", Toast.LENGTH_SHORT).show();
                                    break;
                                case 404:
                                    Toast.makeText(activity, "The server can not find the requested page.", Toast.LENGTH_SHORT).show();
                                    break;
                                case 500:
                                    Toast.makeText(activity, "Internal Server Error..", Toast.LENGTH_SHORT).show();
                                    break;
                                case 503:
                                    Toast.makeText(activity, "Service Unavailable..", Toast.LENGTH_SHORT).show();
                                    break;
                                case 504:
                                    Toast.makeText(activity, "Gateway Timeout..", Toast.LENGTH_SHORT).show();
                                    break;
                                case 511:
                                    Toast.makeText(activity, "Network Authentication Required ..", Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    Toast.makeText(activity, "unknown error", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                        } catch (Exception e) {
                            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<MediaArticleModel> call, Throwable t) {
                    // Handle failure
                    Log.e("conversion issue", t.getMessage());
                    if (t instanceof IOException) {
                        Toast.makeText(activity, "This is an actual network failure :( inform the user and possibly retry)", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("conversion issue", t.getMessage());
                        Toast.makeText(activity, "Please Check your Internet Connection...." + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}
