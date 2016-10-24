package com.ou.reader.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.ou.reader.R;
import com.ou.reader.base.BaseFragment;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.CategoryList;
import com.ou.reader.common.OnRvItemClickListener;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerFindComponent;
import com.ou.reader.ui.activity.MainActivity;
import com.ou.reader.ui.activity.SubCategoryListActivity;
import com.ou.reader.ui.activity.TopRankActivity;
import com.ou.reader.ui.adapter.TopCategoryListAdapter;
import com.ou.reader.ui.contract.TopCategoryListContract;
import com.ou.reader.ui.presenter.TopCategoryListPresenter;
import com.ou.reader.view.SupportGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * author：ou on 2016/10/8 14:39
 * todo
 */
public class BookStoreFragment extends BaseFragment implements TopCategoryListContract.View  {

    @Bind(R.id.rvMaleCategory)
    RecyclerView mRvMaleCategory;
    @Bind(R.id.rvFemaleCategory)
    RecyclerView mRvFeMaleCategory;

    @Inject
    TopCategoryListPresenter mPresenter;

    private TopCategoryListAdapter mMaleCategoryListAdapter;
    private TopCategoryListAdapter mFemaleCategoryListAdapter;
    private List<CategoryList.MaleBean> mMaleCategoryList = new ArrayList<>();
    private List<CategoryList.MaleBean> mFemaleCategoryList = new ArrayList<>();

    MainActivity mActivity;
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_top_category_list;
    }

    @Override
    public void initDatas() {
    }


    @Override
    public void configViews() {

        showDialog();
        mRvMaleCategory.setHasFixedSize(true);
        mRvMaleCategory.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mRvMaleCategory.addItemDecoration(new SupportGridItemDecoration(mActivity));
        mRvFeMaleCategory.setHasFixedSize(true);
        mRvFeMaleCategory.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mRvFeMaleCategory.addItemDecoration(new SupportGridItemDecoration(mActivity));
        mMaleCategoryListAdapter = new TopCategoryListAdapter(mContext, mMaleCategoryList, new ClickListener(Constant.Gender.MALE));
        mFemaleCategoryListAdapter = new TopCategoryListAdapter(mContext, mFemaleCategoryList, new ClickListener(Constant.Gender.FEMALE));
        mRvMaleCategory.setAdapter(mMaleCategoryListAdapter);
        mRvFeMaleCategory.setAdapter(mFemaleCategoryListAdapter);

        mPresenter.attachView(this);
        mPresenter.getCategoryList();
    }

    @Override
    public boolean goback() {
        return false;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        mActivity= (MainActivity) getActivity();
        DaggerFindComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_rank) {
            TopRankActivity.startActivity(mActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void attachView() {
    }



    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        dismissDialog();
    }

    @Override
    public void showCategoryList(CategoryList data) {
        mMaleCategoryList.clear();
        mFemaleCategoryList.clear();
        mMaleCategoryList.addAll(data.male);
        mFemaleCategoryList.addAll(data.female);
        mMaleCategoryListAdapter.notifyDataSetChanged();
        mFemaleCategoryListAdapter.notifyDataSetChanged();
    }
    class ClickListener implements OnRvItemClickListener<CategoryList.MaleBean> {

        private String gender;

        public ClickListener(@Constant.Gender String gender) {
            this.gender = gender;
        }

        @Override
        public void onItemClick(View view, int position, CategoryList.MaleBean data) {
            SubCategoryListActivity.startActivity(mActivity, data.name, gender);
        }
    }
}
