package com.shamsaha.victim.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentPerCountryBinding;
import com.shamsaha.retrofit.API_Client;
import com.shamsaha.victim.adapter.ResourcesPerCountryAdapter;
import com.shamsaha.victim.model.HomeModel;
import com.shamsaha.victim.model.ResourceCategoryModel;
import com.shamsaha.victim.model.ResourcesCountryModel;
import com.shamsaha.victim.model.res.HomeRes;
import com.shamsaha.victim.model.res.ResourcesCaregoryRes;
import com.shamsaha.victim.model.res.ResourcesCountryRes;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerCountryFragment extends Fragment {

  FragmentPerCountryBinding binding;
  List<ResourcesCountryRes> resourcesCountryResList  = new ArrayList<>();
  List<ResourcesCaregoryRes> resourcesCaregoryResList = new ArrayList<>();
  List<String> spinResourceList = new ArrayList<>();
  private String resourceSpinId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPerCountryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        respurces_country_list(view);




        binding.spinPerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //  Toast.makeText(getActivity(), "Country Spinner Working **********", Toast.LENGTH_SHORT).show();

                String item = binding.spinPerCountry.getSelectedItem().toString();
                if (item.equals(resourcesCountryResList.get(0).getLocationName()))
                {
                    resourceSpinId = String.valueOf(resourcesCountryResList.get(0).getWcrid());
                    resources_location_api();
                    // int spinnerPosition = dAdapter.getPosition(compareValue);
                    // spinner_category.setSelection(Integer.parseInt("Select Category"));
                }   else
                {
                    resourceSpinId = String.valueOf(resourcesCountryResList.get(i).getWcrid());
                    resources_location_api();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });

        return view;
    }

    private void resources_location_api() {

            // show till load api data

            final ProgressDialog pd = new ProgressDialog(getActivity());
            pd.setCancelable(false);
            pd.setMessage("loading...");
            pd.show();

            Call<ResourceCategoryModel> call = API_Client.getClient().RESOURCE_CATEGORY_MODEL_CALL("en",resourceSpinId);

            call.enqueue(new Callback<ResourceCategoryModel>() {
                @Override
                public void onResponse(Call<ResourceCategoryModel> call, Response<ResourceCategoryModel> response) {
                    pd.dismiss();
                    try {
                        //if api response is successful ,taking message and success
                        if (response.isSuccessful()) {
                            String message = response.body().getMessage();
                            String success = String.valueOf(response.body().getSuccess());

                            if (success.equals("true") || success.equals("True")) {

                                ResourceCategoryModel resourceCategoryModel = response.body();
                                resourcesCaregoryResList = resourceCategoryModel.getData();

                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                                binding.rcvPerCountryList.setLayoutManager(linearLayoutManager);
                                ResourcesPerCountryAdapter resourcesPerCountryAdapter = new ResourcesPerCountryAdapter(getActivity(),resourcesCaregoryResList);
                                binding.rcvPerCountryList.setAdapter(resourcesPerCountryAdapter);

                               // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
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
                public void onFailure(Call<ResourceCategoryModel> call, Throwable t) {
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

    private void respurces_country_list(View view) {
        // show till load api data

        final ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setCancelable(false);
        pd.setMessage("loading...");
        pd.show();

        Call<ResourcesCountryModel> call = API_Client.getClient().RESOURCES_COUNTRY_MODEL_CALL("en");

        call.enqueue(new Callback<ResourcesCountryModel>() {
            @Override
            public void onResponse(Call<ResourcesCountryModel> call, Response<ResourcesCountryModel> response) {
                pd.dismiss();
                try {
                    //if api response is successful ,taking message and success
                    if (response.isSuccessful()) {
                        String message = response.body().getMessage();
                        String success = String.valueOf(response.body().getSuccess());

                        if (success.equals("true") || success.equals("True")) {


                            ResourcesCountryModel resourcesCountryModel = response.body();
                            resourcesCountryResList = resourcesCountryModel.getData();

                            for(int i=0; i<resourcesCountryResList.size();i++){
                                spinResourceList.add(resourcesCountryResList.get(i).getLocationName());
                            }

                            //Spinner
                            spinnerAdapter dAdapter = new spinnerAdapter(getActivity(), R.layout.custom_spinner_two, spinResourceList);
                            dAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            dAdapter.addAll(spinResourceList);
                            dAdapter.add(resourcesCountryResList.get(0).getLocationName());
                            binding.spinPerCountry.setAdapter(dAdapter);
                            binding.spinPerCountry.setSelection(dAdapter.getCount());


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
            public void onFailure(Call<ResourcesCountryModel> call, Throwable t) {
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

    public class spinnerAdapter extends ArrayAdapter<String>
    {
        private spinnerAdapter(Context context, int textViewResourceId, List<String> smonking)
        {
            super(context, textViewResourceId);
        }

        @Override
        public int getCount()
        {
            int count = super.getCount();
            return count > 0 ? count - 1 : count;
        }
    }
}