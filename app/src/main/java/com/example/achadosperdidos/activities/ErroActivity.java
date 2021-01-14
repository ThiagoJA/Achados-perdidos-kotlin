package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.achadosperdidos.R;
public class ErroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erro);
    }

    public void voltar(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}