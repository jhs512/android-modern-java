package com.example.sbs.myapplication.di;

import com.example.sbs.myapplication.BuildConfig;
import com.example.sbs.myapplication.api.jsonplaceholder.JsonPlaceholderApi;
import com.example.sbs.myapplication.service.ArticleService;
import com.example.sbs.myapplication.util.Util;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class SingletonModule {
    @Provides
    @Singleton
    public static ArticleService provideArticleService(JsonPlaceholderApi jsonPlaceholderApi) {
        return new ArticleService(jsonPlaceholderApi);
    }

    @Provides
    @Singleton
    public static JsonPlaceholderApi provideJsonPlaceholderApi(Retrofit.Builder retrofitBuilder) {
        Retrofit retrofit = retrofitBuilder
                .baseUrl(JsonPlaceholderApi.baseUrl)
                .build();

        return retrofit.create(JsonPlaceholderApi.class);
    }

    @Provides
    public static Retrofit.Builder provideRetrofitBuilder() {
        OkHttpClient stethoInterceptingClient = null;

        if (BuildConfig.DEBUG) {
            stethoInterceptingClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new StethoInterceptor()) // Stetho Interceptor 추가해야 Chrome Inspect tool 에서 확인 가능, 필수 아님
                    .build();
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()) // GSON 사용
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()); // RX Java 사용

        if (stethoInterceptingClient != null) {
            retrofitBuilder.client(stethoInterceptingClient);
        }

        return retrofitBuilder;
    }
}
