package com.ou.reader.ui.contract;

import com.ou.reader.base.BaseContract;
import com.ou.reader.bean.BookHelpList;

import java.util.List;

/**
 * @author lfh.
 * @date 16/9/3.
 */
public interface BookHelpContract {

    interface View extends BaseContract.BaseView {
        void showBookHelpList(List<BookHelpList.HelpsBean> list, boolean isRefresh);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookHelpList(String sort, String distillate, int start, int limit);
    }

}
