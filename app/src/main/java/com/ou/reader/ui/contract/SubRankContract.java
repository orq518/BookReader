package com.ou.reader.ui.contract;

import com.ou.reader.base.BaseContract;
import com.ou.reader.bean.BooksByCats;

/**
 * @author yuyh.
 * @date 16/9/1.
 */
public interface SubRankContract {

    interface View extends BaseContract.BaseView {
        void showCategoryList(BooksByCats data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getRankList(String id);
    }
}
