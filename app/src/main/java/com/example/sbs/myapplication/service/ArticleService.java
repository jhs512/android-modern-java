package com.example.sbs.myapplication.service;

import com.example.sbs.myapplication.api.jsonplaceholder.JsonPlaceholderApi;
import com.example.sbs.myapplication.api.jsonplaceholder.dto.JsonPlaceholderApi__todos__ResponseBody;
import com.example.sbs.myapplication.dto.ResultData;
import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ArticleService {
    private JsonPlaceholderApi jsonPlaceholderApi;

    @Inject
    public ArticleService(JsonPlaceholderApi jsonPlaceholderApi) {
        this.jsonPlaceholderApi = jsonPlaceholderApi;
    }

    public void getArticles(@NonNull Consumer<? super ResultData<JsonPlaceholderApi__todos__ResponseBody>> onNext, @NonNull Consumer<? super Throwable> onFail) {
        Observable<ResultData<JsonPlaceholderApi__todos__ResponseBody>> observable__todosResultData = jsonPlaceholderApi.todos().flatMap(articles -> {

            ResultData<JsonPlaceholderApi__todos__ResponseBody> rd = new ResultData<>();
            rd.body = new JsonPlaceholderApi__todos__ResponseBody();
            rd.body.articles = articles;

            return Observable.just(rd);
        });
        observable__todosResultData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onFail);
    }
}
