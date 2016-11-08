package com.ou.reader.api;

import com.ou.reader.bean.Recommend;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookApiService_New {

    @GET("/book/recommend")
    Call<Recommend> getRecomend(@Query("gender") String gender);


}