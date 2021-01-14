package com.example.achadosperdidos.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.achadosperdidos.R;
import com.example.achadosperdidos.domain.Address;
import com.example.achadosperdidos.domain.AddressDTO;
import com.example.achadosperdidos.domain.AddressInsertDTO;
import com.example.achadosperdidos.domain.Endereco;
import com.example.achadosperdidos.domain.ItemDTO;
import com.example.achadosperdidos.domain.ItemInsertDTO;
import com.example.achadosperdidos.domain.Objeto;
import com.example.achadosperdidos.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ObjetoActivity extends AppCompatActivity {

    private EditText nome_objeto, desc_obj, date_objeto, recomp_obj, logradouro, bairro, cep, cidade;

    private Button button_cadastra_obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objeto);

        nome_objeto = (EditText) findViewById(R.id.nome_objeto);
        desc_obj = (EditText) findViewById(R.id.desc_obj);
        date_objeto = (EditText) findViewById(R.id.date_objeto);
        recomp_obj = (EditText) findViewById(R.id.recomp_obj);
        logradouro = (EditText) findViewById(R.id.logradouro);
        bairro = (EditText) findViewById(R.id.bairro);
        cep = (EditText) findViewById(R.id.cep);
        cidade = (EditText) findViewById(R.id.cidade);

        button_cadastra_obj = (Button) findViewById(R.id.button_cadastra_obj);

        button_cadastra_obj.setOnClickListener(new View.OnClickListener() { //evento do button
            @Override
            public void onClick(View v) {
                AddressInsertDTO endereco = new AddressInsertDTO(0L, Integer.parseInt(cep.getText().toString()),
                        cidade.getText().toString(),bairro.getText().toString(),logradouro.getText().toString());




                RetrofitService.getServico(getApplicationContext()).salva_endereco(endereco).enqueue(new Callback<AddressDTO>() {
                    @Override
                    public void onResponse(Call<AddressDTO> call, Response<AddressDTO> response) {
                        Log.d("resposta","onresponse",response.body());
                        if (response.isSuccessful()) {
                            ItemInsertDTO objeto = new ItemInsertDTO(response.body().getId() ,nome_objeto.getText().toString(),desc_obj.getText().toString(),
                                    date_objeto.getText().toString(), Integer.parseInt(recomp_obj.getText().toString()));

                            RetrofitService.getServico(getApplication()).save_objeto(objeto).enqueue(new Callback<ItemDTO>() {
                                @Override
                                public void onResponse(Call<ItemDTO> call, Response<ItemDTO> response) {
                                    Intent intent = new Intent(ObjetoActivity.this, SucessoObjActivity.class);
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<ItemDTO> call, Throwable t) {
                                    Log.d("resposta","ononFailure" + t.getMessage());
                                    Intent intent = new Intent(ObjetoActivity.this, ErroObjActivity.class);
                                    startActivity(intent);
                                }
                            });

                        }
                    }

                    @Override
                    public void onFailure(Call<AddressDTO> call, Throwable t) {
                        Log.d("resposta","ononFailure" + t.getMessage());

                    }
                });
            }
        });
        limpar_campos();
    }
    private void limpar_campos(){
        System.out.println("testando");
        nome_objeto.setText("");
        desc_obj.setText("");
        date_objeto.setText("");
        recomp_obj.setText("");
        logradouro.setText("");
        bairro.setText("");
        cep.setText("");
        cidade.setText("");
    }
}