package com.ou.reader.ui.fragment;

import com.ou.reader.R;
import com.ou.reader.base.BaseRVFragment;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.BookHelpList;
import com.ou.reader.bean.support.SelectionEvent;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerCommunityComponent;
import com.ou.reader.ui.activity.BookHelpDetailActivity;
import com.ou.reader.ui.contract.BookHelpContract;
import com.ou.reader.ui.easyadapter.BookHelpAdapter;
import com.ou.reader.ui.presenter.BookHelpPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * @author lfh.
 * @date 16/9/3.
 */
public class BookHelpFragment extends BaseRVFragment<BookHelpPresenter, BookHelpList.HelpsBean> implements BookHelpContract.View {

    private String sort = Constant.SortType.DEFAULT;
    private String distillate = Constant.Distillate.ALL;

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerCommunityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initDatas() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void configViews() {
        initAdapter(BookHelpAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void showBookHelpList(List<BookHelpList.HelpsBean> list, boolean isRefresh) {
        if (isRefresh) {
            mAdapter.clear();
        }
        mAdapter.addAll(list);
        start = start + list.size();
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initCategoryList(SelectionEvent event) {
        mRecyclerView.setRefreshing(true);
        sort = event.sort;
        distillate = event.distillate;
        onRefresh();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getBookHelpList(sort, distillate, 0, limit);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getBookHelpList(sort, distillate, start, limit);
    }

    @Override
    public void onItemClick(int position) {
        BookHelpList.HelpsBean data = mAdapter.getItem(position);
        BookHelpDetailActivity.startActivity(activity, data._id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean goback() {
        return false;
    }

}
