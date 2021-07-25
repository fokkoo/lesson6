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
import android.widget.LinearLayout;
import android.widget.TextView;


public class ExersicesTextFragment extends Fragment {

    public static final String ARG_PARAM_INDEX = "index";
    public static final int DEF_INDEX = -1;

    private int index;


    public ExersicesTextFragment() {
        // Required empty public constructor
    }

 /*   public static ImageFragment newInstance(int index) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_INDEX, index);

        fragment.setArguments(args);
        return fragment;
    } */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_PARAM_INDEX);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //  initImage(view);

        intList(view);
    }

    private void intList(View view) {

        //    LinearLayout linearLayout = view.findViewById(R.id.eserciser_conteiner);
        LinearLayout linearLayout = (LinearLayout) view;

        String[] exercises2 = getResources().getStringArray(R.array.exercisesText);


        TextView textView2 = new TextView(getContext());
        textView2.setText(exercises2[2]);
        textView2.setTextSize(30);


        linearLayout.addView(textView2);

    }


    private void initImage(View view) {
        ImageView imageView = view.findViewById(R.id.image);
        TypedArray images = getResources().obtainTypedArray(R.array.exercisesPhoto);
        imageView.setImageResource(images.getResourceId(index, DEF_INDEX));

        images.recycle();

    }

}
