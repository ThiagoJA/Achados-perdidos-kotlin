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
import com.google.gson.JsonIOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void cadastrarUsuario(View view) {
        String nome = ((EditText)findViewById(R.id.nome)).getText().toString();
        String email = ((EditText)findViewById(R.id.email)).getText().toString();
        String senha = ((EditText)findViewById(R.id.senha)).getText().toString();
        String cpf = ((EditText)findViewById(R.id.cpf)).getText().toString();
        String telefone = ((EditText)findViewById(R.id.telefone)).getText().toString();

        DtoUser dtoUser = new DtoUser(cpf, email, nome, senha, telefone);

        RetrofitService.getServico(this).cadastrar_usuario(dtoUser).enqueue(new Callback<DtoUser>() {
            private static final String TAG = "CadastroDeUsuario";
            @Override
            public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                Toast.makeText(CadastroActivity.this, "Usuário cadastrado com ID: "+response.body().getId(), Toast.LENGTH_LONG).show();
               Intent intent = new Intent(CadastroActivity.this, SucessoActivity.class);
               startActivity(intent);
            }

            @Override
            public void onFailure(Call<DtoUser> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                Intent intent = new Intent(CadastroActivity.this, ErroActivity.class);
                startActivity(intent);
            }
        });
    }
}