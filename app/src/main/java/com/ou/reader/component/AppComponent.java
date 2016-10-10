package com.ou.reader.component;

import android.content.Context;

import com.ou.reader.api.BookApi;
import com.ou.reader.module.AppModule;
import com.ou.reader.module.BookApiModule;

import dagger.Component;

/**
 * @author yuyh.
 * @date 2016/8/3.
 */
@Component(modules = {AppModule.class, BookApiModule.class})
public interface AppComponent {

    Context getContext();

    BookApi getReaderApi();

}