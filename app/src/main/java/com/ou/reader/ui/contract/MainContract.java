package com.ou.reader.ui.contract;

import com.ou.reader.base.BaseContract;

/**
 * @author yuyh.
 * @date 2016/8/3.
 */
public interface MainContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void login(String uid, String token, String platform);
    }

}
