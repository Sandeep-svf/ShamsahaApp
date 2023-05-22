package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentArticlesBinding;
import com.shamsaha.util.GridSpacingItemDecoration;
import com.shamsaha.victim.adapter.EventMediaArticleAdapter;
import com.shamsaha.victim.adapter.EventMediaPhotoAdapter;
import com.shamsaha.victim.adapter.ResourcesSST;
import com.shamsaha.victim.model.res.MediaArticleRes;
import com.shamsaha.victim.viewmodel.MediaArticleViewModel;

import java.util.ArrayList;
import java.util.List;


public class ArticlesFragment extends Fragment {


    FragmentArticlesBinding binding;
    private MediaArticleViewModel viewModel;
    private List<MediaArticleRes> mediaArticleResList = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentArticlesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(MediaArticleViewModel.class);


        viewModel.getMediaArticleList("en",getActivity()).observe(getActivity(),mediaArticleModel -> {
            String success = mediaArticleModel.getSuccess();
            String message = mediaArticleModel.getMessage();

            if(success.equalsIgnoreCase("true")){
                mediaArticleResList = mediaArticleModel.getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                binding.rcvArticle.setLayoutManager(linearLayoutManager);
                EventMediaArticleAdapter resourcesSST = new EventMediaArticleAdapter(getActivity(),mediaArticleResList);
                binding.rcvArticle.setAdapter(resourcesSST);


            }else{
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }

        });



        return  view;
    }
}