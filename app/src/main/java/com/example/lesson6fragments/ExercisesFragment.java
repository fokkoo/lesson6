package com.example.lesson6fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ExercisesFragment extends Fragment {

    public static final String ARM_PARAM_INDEX = "index";
    public static final int DEF_INDEX = -1;

    private int index;

    public ExercisesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_exercises, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        intList(view);
    }

    private void intList(View view) {
        LinearLayout linearLayout = view.findViewById(R.id.eserciser_conteiner);

        String[] exersises = getResources().getStringArray(R.array.exercises);

        for (int i = 0; i < exersises.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(exersises[i]);
            textView.setTextSize(30);


            final int finalIndex = i;
            textView.setOnClickListener(v -> {
                showImage(finalIndex);

            });

            linearLayout.addView(textView);
        }
    }


    void showImage(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ImageActivity.class);
        intent.putExtra(ExercisesFragment.ARM_PARAM_INDEX, index);
        startActivity(intent);

    }


}