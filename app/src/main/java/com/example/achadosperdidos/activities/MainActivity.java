package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.achadosperdidos.R;
import com.example.achadosperdidos.dto.DtoUser;
import com.example.achadosperdidos.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listarObjetos();

    }

    public void abrirCadastrar(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void abrirRecuperarSenha(View view) {
        startActivity(new Intent(this, RecuperarSenhaActivity.class));
    }

    public void listarObjetos() {
        startActivity(new Intent(this, ListaObjetosActivity.class));
    }

    public void logar(View view) {
        String email = ((EditText)findViewById(R.id.login_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.login_senha)).getText().toString();
        RetrofitService.getServico(this).logar(email, password).enqueue(new Callback<DtoUser>() {
            @Override
            public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                if (response.body().getId() >= 1){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, ErroActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<DtoUser> call, Throwable t) {
                Intent intent = new Intent(MainActivity.this, ErroActivity.class);
                startActivity(intent);
            }
        });
    }
}