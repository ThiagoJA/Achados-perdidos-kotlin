package com.example.achadosperdidos.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.achadosperdidos.R;
import com.example.achadosperdidos.activities.ErroActivity;
import com.example.achadosperdidos.activities.MainActivity;

public class SairFragment extends Fragment implements View.OnClickListener{
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_sair, container, false);

            Button button = (Button) view.findViewById(R.id.sair);
            button.setOnClickListener(this::onClick);

            return view;
        }

        public static com.example.achadosperdidos.fragments.SairFragment newInstance() {
            return new com.example.achadosperdidos.fragments.SairFragment();
        }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity() ,MainActivity.class);
        startActivity(intent);
    }
}