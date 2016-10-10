package com.ou.reader.ui.contract;

import com.ou.reader.base.BaseContract;
import com.ou.reader.bean.CategoryListLv2;

/**
 * @author lfh.
 * @date 2016/8/30.
 */
public interface SubCategoryActivityContract {

    interface View extends BaseContract.BaseView {
        void showCategoryList(CategoryListLv2 data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getCategoryListLv2();
    }

}
