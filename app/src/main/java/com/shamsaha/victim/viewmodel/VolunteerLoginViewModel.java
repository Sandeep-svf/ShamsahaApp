package com.shamsaha.victim.viewmodel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.shamsaha.retrofit.API_Client;
import com.shamsaha.retrofit.Api;
import com.shamsaha.victim.model.VolunteerLoginModel;
import com.shamsaha.victim.model.res.VolunteerLoginRes;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VolunteerLoginViewModel extends ViewModel {
    private MutableLiveData<VolunteerLoginModel> userLiveData;


    public LiveData<VolunteerLoginModel> getUser(String email, String password) {
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<>();
            loadUser(email,password); // Simulate loading user data
        }
        return userLiveData;
    }
    private void loadUser(String email, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_Client.BASE_URL) // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api apiService = retrofit.create(Api.class);

        Call<VolunteerLoginModel> call = apiService.VOLUNTEER_LOGIN_MODEL_CALL(email,password);
        call.enqueue(new Callback<VolunteerLoginModel>() {
            @Override
            public void onResponse(Call<VolunteerLoginModel> call, Response<VolunteerLoginModel> response) {
                if (response.isSuccessful()) {
                    VolunteerLoginModel volunteerLoginModel = response.body();
                    userLiveData.setValue(volunteerLoginModel);
                }
            }

            @Override
            public void onFailure(Call<VolunteerLoginModel> call, Throwable t) {
                // Handle failure

            }
        });
    }
}
