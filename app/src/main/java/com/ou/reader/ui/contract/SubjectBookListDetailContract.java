package com.ou.reader.ui.contract;

import com.ou.reader.base.BaseContract;
import com.ou.reader.bean.BookListDetail;

/**
 * @author lfh.
 * @date 2016/8/31.
 */
public interface SubjectBookListDetailContract {

    interface View extends BaseContract.BaseView {
        void showBookListDetail(BookListDetail data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookListDetail(String bookListId);
    }
}
