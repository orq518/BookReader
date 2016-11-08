package com.ou.reader.listener.net;

import com.ou.reader.api.support.HeaderInterceptor;
import com.ou.reader.api.support.LoggingInterceptor;
import com.ou.reader.listener.api.ListenBaseUrl;
import com.ou.reader.listener.api.ListenBookApiService;
import com.ou.reader.module.BookApiModule;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ou.
 * @date 2016/10/3.
 */
public class ListenNet {

    public static ListenNet instance;

    private ListenBookApiService service;

    public ListenNet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ListenBaseUrl.LISTEN_BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(provideOkHttpClient())
                .build();
        service = (ListenBookApiService) retrofit.create(ListenBookApiService.class);
    }

    public static ListenNet getInstance() {
        if (instance == null)
            instance = new ListenNet();
        return instance;
    }

    public ListenBookApiService getService() {
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
