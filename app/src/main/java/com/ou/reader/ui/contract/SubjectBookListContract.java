package com.ou.reader.ui.contract;

import com.ou.reader.base.BaseContract;
import com.ou.reader.bean.BookListTags;

/**
 * @author yuyh.
 * @date 2016/8/31.
 */
public interface SubjectBookListContract {

    interface View extends BaseContract.BaseView {
        void showBookListTags(BookListTags data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookListTags();
    }
}
