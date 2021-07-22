package com.example.lesson6fragments;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageFragment extends Fragment {


    private static final String ARG_PARAM_INDEX = "index";


    private int index;


    public ImageFragment() {
        // Required empty public constructor
    }


    public static ImageFragment newInstance(int index) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_INDEX, index);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_PARAM_INDEX);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initImage(view);
    }

    private void initImage(View view) {
        ImageView imageView = view.findViewById(R.id.image);
        TypedArray images = getResources().obtainTypedArray(R.array.exercisesPhoto);
        imageView.setImageResource(images.getResourceId(index, -1));

        images.recycle();
    }


}