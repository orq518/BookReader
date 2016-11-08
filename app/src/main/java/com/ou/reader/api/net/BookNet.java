package com.ou.reader.api.net;

import com.ou.reader.api.BookApiService_New;
import com.ou.reader.api.support.HeaderInterceptor;
import com.ou.reader.api.support.LoggingInterceptor;
import com.ou.reader.module.BookApiModule;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ou.reader.base.Constant.API_BASE_URL;

/**
 * @author ou.
 * @date 2016/10/3.
 */
public class BookNet {

    public static BookNet instance;

    private BookApiService_New service;

    public BookNet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(provideOkHttpClient())
                .build();
        service = (BookApiService_New) retrofit.create(BookApiService_New.class);
    }

    public static BookNet getInstance() {
        if (instance == null)
            instance = new BookNet();
        return instance;
    }

    public BookApiService_New getService() {
        return service;
    }
    public OkHttpClient provideOkHttpClient() {

        LoggingInterceptor logging = new LoggingInterceptor(new BookApiModule.MyLog());
        logging.setLevel(LoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(logging);
        return builder.build();
    }

}
