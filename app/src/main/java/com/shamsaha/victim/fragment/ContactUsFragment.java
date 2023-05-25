package com.shamsaha.victim.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shamsaha.R;
import com.shamsaha.databinding.FragmentContactUsBinding;
import com.shamsaha.retrofit.API_Client;
import com.shamsaha.util.UtilFunction;
import com.shamsaha.util.WebviewActivity;
import com.shamsaha.victim.model.CommonModel;
import com.shamsaha.victim.model.ContactUsDataModel;
import com.shamsaha.victim.model.res.ContactUsDataRes;

import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactUsFragment extends Fragment {

    FragmentContactUsBinding binding;
    private String locationUrl = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentContactUsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        get_contact_data_api();

        binding.locationImageContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!locationUrl.equals("")){
                    Intent intent = new Intent(getActivity(), WebviewActivity.class);
                    intent.putExtra("url",locationUrl);
                    intent.putExtra("key",UtilFunction.googleLocationKey);
                    startActivity(intent);
                }
            }
        });

        binding.submitButtonContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validation()){
                    contact_us_api();
                }else{
                    Toast.makeText(getActivity(), getResources().getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return  view;
    }

    private void get_contact_data_api() {
            // show till load api data

            final ProgressDialog pd = new ProgressDialog(getActivity());
            pd.setCancelable(false);
            pd.setMessage("loading...");
            pd.show();

            Call<ContactUsDataModel> call = API_Client.getClient().CONTACT_US_DATA_CALL("en");

            call.enqueue(new Callback<ContactUsDataModel>() {
                @Override
                public void onResponse(Call<ContactUsDataModel> call, Response<ContactUsDataModel> response) {
                    pd.dismiss();
                    try {
                        //if api response is successful ,taking message and success
                        if (response.isSuccessful()) {
                            String message = response.body().getMessage();
                            String success = String.valueOf(response.body().getSuccess());

                            if (success.equals("true") || success.equals("True")) {

                                ContactUsDataModel contactUsDataModel = response.body();
                                ContactUsDataRes contactUsDataRes = contactUsDataModel.getData();

                                Glide.with(getActivity())
                                        .load(contactUsDataRes.getImage())
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .into(binding.imageContactUs);
                                binding.textView4.setText(contactUsDataRes.getContent());
                                binding.addressContactUs.setText(contactUsDataRes.getAddress());
                                locationUrl = contactUsDataRes.getGoogleMap();

                                Log.e("test_sam",contactUsDataRes.getImage());
                                Log.e("test_sam",contactUsDataRes.getGoogleMap());


                            } else {
                                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            try {
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
                                Log.e("user_id", "    Message");
                                Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                                switch (response.code()) {
                                    case 400:
                                        Toast.makeText(getActivity(), "The server did not understand the request.", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 401:
                                        Toast.makeText(getActivity(), "Unauthorized The requested page needs a username and a password.", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 404:
                                        Toast.makeText(getActivity(), "The server can not find the requested page.", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 500:
                                        Toast.makeText(getActivity(), "Internal Server Error..", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 503:
                                        Toast.makeText(getActivity(), "Service Unavailable..", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 504:
                                        Toast.makeText(getActivity(), "Gateway Timeout..", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 511:
                                        Toast.makeText(getActivity(), "Network Authentication Required ..", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        Toast.makeText(getActivity(), "unknown error", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    } catch (
                            Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ContactUsDataModel> call, Throwable t) {
                    Log.e("conversion issue", t.getMessage());

                    if (t instanceof IOException) {
                        Toast.makeText(getActivity(), "This is an actual network failure :( inform the user and possibly retry)", Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    } else {
                        Log.e("conversion issue", t.getMessage());
                        Toast.makeText(getActivity(), "Please Check your Internet Connection...." + t.getMessage(), Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }
                }
            });

        }

    private void contact_us_api() {
            // show till load api data

            final ProgressDialog pd = new ProgressDialog(getActivity());
            pd.setCancelable(false);
            pd.setMessage("loading...");
            pd.show();

            Call<CommonModel> call = API_Client.getClient().COMMON_MODEL_CONTACT_US_CALL("en",
                    binding.nameContactUs.getText().toString(),
                    binding.phoneContactUs.getText().toString(),
                    binding.emailContactUs.getText().toString(),
                    binding.messageContactUs.getText().toString());

            call.enqueue(new Callback<CommonModel>() {
                @Override
                public void onResponse(Call<CommonModel> call, Response<CommonModel> response) {
                    pd.dismiss();
                    try {
                        //if api response is successful ,taking message and success
                        if (response.isSuccessful()) {
                            String message = response.body().getMessage();
                            String success = String.valueOf(response.body().getSuccess());

                            if (success.equals("true") || success.equals("True")) {
                                        binding.nameContactUs.setText("");
                                        binding.phoneContactUs.setText("");
                                        binding.emailContactUs.setText("");
                                        binding.messageContactUs.setText("");
                                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            try {
                                JSONObject jObjError = new JSONObject(response.errorBody().string());
                                Log.e("user_id", "    Message");
                                Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                                switch (response.code()) {
                                    case 400:
                                        Toast.makeText(getActivity(), "The server did not understand the request.", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 401:
                                        Toast.makeText(getActivity(), "Unauthorized The requested page needs a username and a password.", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 404:
                                        Toast.makeText(getActivity(), "The server can not find the requested page.", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 500:
                                        Toast.makeText(getActivity(), "Internal Server Error..", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 503:
                                        Toast.makeText(getActivity(), "Service Unavailable..", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 504:
                                        Toast.makeText(getActivity(), "Gateway Timeout..", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 511:
                                        Toast.makeText(getActivity(), "Network Authentication Required ..", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        Toast.makeText(getActivity(), "unknown error", Toast.LENGTH_SHORT).show();
                                        break;
                                }

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    } catch (
                            Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<CommonModel> call, Throwable t) {
                    Log.e("conversion issue", t.getMessage());

                    if (t instanceof IOException) {
                        Toast.makeText(getActivity(), "This is an actual network failure :( inform the user and possibly retry)", Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    } else {
                        Log.e("conversion issue", t.getMessage());
                        Toast.makeText(getActivity(), "Please Check your Internet Connection...." + t.getMessage(), Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }
                }
            });

        }

    private boolean validation() {
        if(binding.nameContactUs.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_name), Toast.LENGTH_SHORT).show();
            return false;
        }else if(binding.phoneContactUs.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_phone), Toast.LENGTH_SHORT).show();
            return false;
        }else if(binding.emailContactUs.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_email), Toast.LENGTH_SHORT).show();
            return false;
        }else if(!binding.emailContactUs.getText().toString().matches(UtilFunction.regexEmail)){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_valid_email), Toast.LENGTH_SHORT).show();
            return false;
        }else if(binding.messageContactUs.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_message), Toast.LENGTH_SHORT).show();
            return false;
        }else if(!binding.checkboxContactUs.isChecked()){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_check_privacy_pocily), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}