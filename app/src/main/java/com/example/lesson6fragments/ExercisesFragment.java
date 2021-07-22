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




    public ExercisesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_exercises, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        intList(view);
    }

    private void intList(View view) {

      //    LinearLayout linearLayout = view.findViewById(R.id.eserciser_conteiner);
        LinearLayout linearLayout = (LinearLayout) view;

        String[] exercises = getResources().getStringArray(R.array.exercises);

        for (int i = 0; i < exercises.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(exercises[i]);
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
        intent.putExtra(ImageFragment.ARG_PARAM_INDEX, index);
        startActivity(intent);

    }


}