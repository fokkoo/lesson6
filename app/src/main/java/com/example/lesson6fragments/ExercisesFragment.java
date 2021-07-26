package com.example.lesson6fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ExercisesFragment extends Fragment {

    private boolean isLand = false;
    public int finalIndex2;
    public int DEFAULT_INDEX = 0;


    public ExercisesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);  //fragment does not recreated with activity
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

        isLand = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (isLand) {
            showImageLand(DEFAULT_INDEX);
        }

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
            finalIndex2 = finalIndex;

            textView.setOnClickListener(v -> {
                showImage(finalIndex);
                //  showText(finalIndex);

            });

            linearLayout.addView(textView);
        }
    }

    void showText(int index) {
        if (isLand) {
            showTextLand(index);
        } else {
            showTextPort(index);
        }
    }

    void showTextLand(int index) {
        ImageFragment fragment = ImageFragment.newInstance(index);

        requireActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.coat_of_arms, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) добавление анимации перехода плавного моего текста и картинки

    }


    void showTextPort(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ImageActivity.class);
        intent.putExtra(ImageFragment.ARG_PARAM_INDEX, index);
        startActivity(intent);


    }

    void showImage(int index) {
        if (isLand) {
            showImageLand(index);
        } else {
            showImagePort(index);
        }
    }

    void showImageLand(int index) {
        ImageFragment fragment = ImageFragment.newInstance(index);

        requireActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.coat_of_arms, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) добавление анимации перехода


    }


    void showImagePort(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ImageActivity.class);
        intent.putExtra(ImageFragment.ARG_PARAM_INDEX, index);
        startActivity(intent);


    }
}