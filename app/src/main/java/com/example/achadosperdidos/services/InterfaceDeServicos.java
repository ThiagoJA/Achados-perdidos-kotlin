package com.example.achadosperdidos.services;


import com.example.achadosperdidos.domain.Address;
import com.example.achadosperdidos.domain.AddressDTO;
import com.example.achadosperdidos.domain.AddressInsertDTO;
import com.example.achadosperdidos.domain.ItemDTO;
import com.example.achadosperdidos.domain.ItemInsertDTO;
import com.example.achadosperdidos.domain.Objeto;
import com.example.achadosperdidos.domain.ObjetoDto;
import com.example.achadosperdidos.domain.ObjetoDto2;
import com.example.achadosperdidos.dto.DtoUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface InterfaceDeServicos {

    @POST("/items")
    Call<ItemDTO> save_objeto(@Body ItemInsertDTO dto);

    @POST("/address")
    Call<AddressDTO> salva_endereco(@Body AddressInsertDTO dto);

    @GET("/items")
    Call<List<ItemDTO>> listarObjetos();//lista objetos para deletar

    @DELETE("/items/{id}")
    Call<Void> excluir_objeto(@Path("id") Long id);

    @GET("/users/findByCpf/{cpf}")
    Call<DtoUser> buscar_cpf(@Path("cpf") String cpf);

    @POST("/users/login/{email}/{password}")
    Call<DtoUser> logar(@Path("email") String email, @Path("password") String password);

    @POST("/users")
    Call<DtoUser> cadastrar_usuario(@Body DtoUser dtoUser);

    @PUT("/users/{cpf}")
    Call<DtoUser> alterar_senha(@Path("cpf") String cpf, @Body DtoUser dtoUser);

}