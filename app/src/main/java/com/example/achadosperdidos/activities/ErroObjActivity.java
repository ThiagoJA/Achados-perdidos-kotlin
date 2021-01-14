package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.achadosperdidos.R;
public class ErroObjActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erro_obj);
    }


    public void voltarHome(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}