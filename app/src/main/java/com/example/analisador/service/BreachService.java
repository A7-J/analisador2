package com.example.analisador.service;

import com.example.analisador.model.Breach;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BreachService {
    @GET("breaches")
    Call<List<Breach>> getRecentBreaches();

    @GET("check/{hash_prefix}")
    Call<String> checkPasswordBreach(@Path("hash_prefix") String hashPrefix);
}
