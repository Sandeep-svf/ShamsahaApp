package com.shamsaha.victim.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.shamsaha.R;
import com.shamsaha.databinding.FragmentAboutBinding;
import com.shamsaha.databinding.FragmentArticlesBinding;
import com.shamsaha.retrofit.API_Client;
import com.shamsaha.util.GridSpacingItemDecoration;
import com.shamsaha.victim.adapter.AboutAdvisoryBoardAdapter;
import com.shamsaha.victim.adapter.EventMediaPhotoAdapter;
import com.shamsaha.victim.model.AboutBoardMemberModel;
import com.shamsaha.victim.model.AboutModel;
import com.shamsaha.victim.model.HomeModel;
import com.shamsaha.victim.model.res.AboutBoardMemberRes;
import com.shamsaha.victim.model.res.AboutRes;
import com.shamsaha.victim.model.res.HomeRes;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutFragment extends Fragment {

    FragmentAboutBinding binding;
    List<AboutBoardMemberRes> aboutBoardMemberResList = new ArrayList<>();
    private Context context;
    private AboutModel aboutModel;
    private AboutRes aboutRes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        context = getActivity();
       /* */


        binding.appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
        {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset)
            {

                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {
                    //  on Collapse
                    binding.sl8934934.setBackgroundResource(R.color.dark_pick_them);
                }
                else
                {
                    //  on expand
                    binding.sl8934934.setBackgroundResource(R.color.pick_them);
                }
            }
        });
        runthread();
        runthread1();


        binding.info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog_message("info1");
            }
        });

        binding.info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog_message("info2");
            }
        });

        return binding.getRoot();
    }

    private void alert_dialog_message(String key) {

        AlertDialog dialogs;

        LayoutInflater inflater= LayoutInflater.from(context);
        View alertLayout = inflater.inflate(R.layout.about_details, null);
        final AppCompatImageView close_dialog = alertLayout.findViewById(R.id.close_dialog);
        final AppCompatTextView description = alertLayout.findViewById(R.id.description);
        final AppCompatTextView director_name = alertLayout.findViewById(R.id.director_name);
        final AppCompatTextView designation_name = alertLayout.findViewById(R.id.designation_name);
        final AppCompatTextView designation_description = alertLayout.findViewById(R.id.designation_description);

        try {
            if(key.equals("info1")){
                director_name.setText(aboutRes.getName1());
                description.setText(aboutRes.getAbout1());
                designation_name.setText(aboutRes.getTag1());
                designation_description.setText(aboutRes.getPost1());
            }else if(key.equals("info2")){
                director_name.setText(aboutRes.getName2());
                description.setText(aboutRes.getAbout2());
                designation_name.setText(aboutRes.getTag2());
                designation_description.setText(aboutRes.getPost2());
            }else{
                Toast.makeText(context, getResources().getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }


        final androidx.appcompat.app.AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setView(alertLayout);
        alert.setCancelable(false);

        dialogs = alert.create();
        dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogs.show();
        dialogs.setCanceledOnTouchOutside(true);


        close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogs.dismiss();
            }
        });
    }

    private void runthread1() {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // about data api
                about_api();
            }
        });
    }



    private void runthread() {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // board member api
                board_member();
            }
        });
}

    private void board_member() {

            // show till load api data

            final ProgressDialog pd = new ProgressDialog(getActivity());
            pd.setCancelable(false);
            pd.setMessage("loading...");
            pd.show();

            Call<AboutBoardMemberModel> call = API_Client.getClient().ABOUT_BOARD_MEMBER_MODEL_CALL("en");

            call.enqueue(new Callback<AboutBoardMemberModel>() {
                @Override
                public void onResponse(Call<AboutBoardMemberModel> call, Response<AboutBoardMemberModel> response) {
                    pd.dismiss();
                    try {
                        //if api response is successful ,taking message and success
                        if (response.isSuccessful()) {
                            String message = response.body().getMessage();
                            String success = String.valueOf(response.body().getSuccess());

                            if (success.equals("true") || success.equals("True")) {

                                aboutBoardMemberResList = response.body().getData();

                                RecyclerView.LayoutManager topLayoutManager = new GridLayoutManager(getActivity(), 3);
                                binding.rcvAdvisoryBoard.setLayoutManager(topLayoutManager);
                                binding.rcvAdvisoryBoard.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(8), true));
                                binding.rcvAdvisoryBoard.setItemAnimator(new DefaultItemAnimator());
                                binding.rcvAdvisoryBoard.setLayoutManager(topLayoutManager);
                                AboutAdvisoryBoardAdapter aboutAdvisoryBoardAdapter = new AboutAdvisoryBoardAdapter(getActivity(),aboutBoardMemberResList);
                                binding.rcvAdvisoryBoard.setAdapter(aboutAdvisoryBoardAdapter);

                                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

                            } else {


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
                public void onFailure(Call<AboutBoardMemberModel> call, Throwable t) {
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

    private void about_api() {

            // show till load api data

            final ProgressDialog pd = new ProgressDialog(getActivity());
            pd.setCancelable(false);
            pd.setMessage("loading...");
            pd.show();

            Call<AboutModel> call = API_Client.getClient().ABOUT_MODEL_CALL("en");

            call.enqueue(new Callback<AboutModel>() {
                @Override
                public void onResponse(Call<AboutModel> call, Response<AboutModel> response) {
                    pd.dismiss();
                    try {
                        //if api response is successful ,taking message and success
                        if (response.isSuccessful()) {
                            String message = response.body().getMessage();
                            String success = String.valueOf(response.body().getSuccess());

                            if (success.equals("true") || success.equals("True")) {

                                 aboutModel = response.body();
                                 aboutRes = aboutModel.getData();

                                 binding.directorName.setText(aboutRes.getName1());
                                 binding.designationName.setText(aboutRes.getTag1());
                                 binding.designationDescription.setText(aboutRes.getPost1());

                                 binding.founderName.setText(aboutRes.getName2());
                                 binding.designationName2.setText(aboutRes.getTag2());
                                 binding.designationDescription2.setText(aboutRes.getPost2());


                                 binding.sl3636.setText(aboutRes.getContent1());
                                 binding.sl3232.setText(aboutRes.getContent2());
                                 binding.sl34834.setText(aboutRes.getContent3());
                                 binding.sl8798323.setText(aboutRes.getContent4());

                                Glide.with(getActivity())
                                        .load(aboutRes.getImage1())
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .into(binding.DirectorImageView);


                                Glide.with(getActivity())
                                        .load(aboutRes.getImage2())
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .into(binding.FounderImageView);

                                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

                            } else {


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
                public void onFailure(Call<AboutModel> call, Throwable t) {
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

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}