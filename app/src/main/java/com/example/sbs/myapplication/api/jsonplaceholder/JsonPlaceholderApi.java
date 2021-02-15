package com.example.sbs.myapplication.api.jsonplaceholder;

import com.example.sbs.myapplication.dto.Article;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {
    /*
    String baseUrl = "https://jsonplaceholder.typicode.com/";

    @GET("/todos")
    Observable<List<Article>> todos();
    */

    String baseUrl = "http://10.0.2.2:3000/";

    @GET("/post")
    Observable<List<Article>> todos();
}
