package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.achadosperdidos.R;
import com.example.achadosperdidos.dto.DtoUser;
import com.example.achadosperdidos.services.RetrofitService;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecuperarSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);
    }

    public void alterarSenha(View view) {
        String cpf = ((EditText)findViewById(R.id.cpf)).getText().toString();
        String novaSenha = ((EditText)findViewById(R.id.nova_senha)).getText().toString();
        RetrofitService.getServico(this).buscar_cpf(cpf).enqueue(new Callback<DtoUser>() {
            private static final String TAG = "CadastroDeUsuario";
            @Override
            public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                DtoUser dtoUser = new DtoUser(cpf, response.body().getEmail(), response.body().getName(), novaSenha, response.body().getPhone());
                TrocarSenha(cpf, dtoUser);
            }

            @Override
            public void onFailure(Call<DtoUser> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                Intent intent = new Intent(RecuperarSenhaActivity.this, ErroActivity.class);
                startActivity(intent);
            }
        });
    }

    public void TrocarSenha(String cpf, DtoUser dtoUser) {
        RetrofitService.getServico(this).alterar_senha(cpf, dtoUser).enqueue(new Callback<DtoUser>() {
            private static final String TAG = "CadastroDeUsuario";
            @Override
            public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                Toast.makeText(RecuperarSenhaActivity.this, "Senha alterada com sucesso", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RecuperarSenhaActivity.this, SucessoActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<DtoUser> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                Intent intent = new Intent(RecuperarSenhaActivity.this, ErroActivity.class);
                startActivity(intent);
            }
        });
    }
}