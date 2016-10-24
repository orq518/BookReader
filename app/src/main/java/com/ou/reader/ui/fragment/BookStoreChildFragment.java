package com.ou.reader.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.ou.reader.R;
import com.ou.reader.base.BaseFragment;
import com.ou.reader.bean.CategoryList;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerFindComponent;
import com.ou.reader.ui.activity.MainActivity;
import com.ou.reader.ui.activity.TopRankActivity;
import com.ou.reader.ui.contract.TopCategoryListContract;
import com.ou.reader.view.RVPIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * author：ou on 2016/10/8 14:39
 * todo
 */
public class BookStoreChildFragment extends BaseFragment implements TopCategoryListContract.View  {
    @Bind(R.id.indicatorSubject)
    RVPIndicator mIndicator;
    @Bind(R.id.viewpagerSubject)
    ViewPager mViewPager;

    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;
    private List<String> mDatas;
    private FragmentManager fm;


    MainActivity mActivity;
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_top_category_list;
    }

    @Override
    public void initDatas() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.subject_ind));
        mTabContents = new ArrayList<>();
        mTabContents.add(SubjectFragment.newInstance("", 0));
        mTabContents.add(SubjectFragment.newInstance("", 1));

        mAdapter = new FragmentPagerAdapter(fm) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };
    }


    @Override
    public void configViews() {

        showDialog();
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager, 0);

    }

    @Override
    public boolean goback() {
        return false;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        mActivity= (MainActivity) getActivity();
        fm = mActivity.getSupportFragmentManager();
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

    }
}
