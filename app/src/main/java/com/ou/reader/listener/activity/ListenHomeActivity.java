package com.ou.reader.listener.activity;

import com.ou.reader.R;
import com.ou.reader.base.BaseActivity;
import com.ou.reader.bean.ListenBook_HomeBean;
import com.ou.reader.component.AppComponent;
import com.ou.reader.listener.net.ListenNet;
import com.ou.reader.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 书荒求助区
 */
public class ListenHomeActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_detail;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("书区");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        LogUtils.d("########1111");
        Call<ListenBook_HomeBean> call = ListenNet.getInstance().getService().getListenHome();
        //异步请求
        call.enqueue(new Callback<ListenBook_HomeBean>() {
            @Override
            public void onResponse(Call<ListenBook_HomeBean> call, Response<ListenBook_HomeBean> response) {
                // Get result bean from response.body()
                ListenBook_HomeBean repos = response.body();
                // Get header item from response
                String links = response.headers().get("Link");
                LogUtils.d("########");
            }

            @Override
            public void onFailure(Call<ListenBook_HomeBean> call, Throwable t) {

            }
        });

//// 取消
//        call.cancel();


    }


    @Override
    public void configViews() {

    }
}
