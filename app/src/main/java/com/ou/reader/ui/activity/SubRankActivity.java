package com.ou.reader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;

import com.ou.reader.R;
import com.ou.reader.base.BaseActivity;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerFindComponent;
import com.ou.reader.ui.fragment.SubRankFragment;
import com.ou.reader.view.RVPIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * @author yuyh.
 * @date 16/9/1.
 */
public class SubRankActivity extends BaseActivity {

    public static final String INTENT_WEEK = "_id";
    public static final String INTENT_MONTH = "month";
    public static final String INTENT_ALL = "all";
    public static final String INTENT_TITLE = "title";

    public static void startActivity(Context context, String week, String month, String all, String title) {
        context.startActivity(new Intent(context, SubRankActivity.class)
                .putExtra(INTENT_WEEK, week)
                .putExtra(INTENT_MONTH, month)
                .putExtra(INTENT_ALL, all)
                .putExtra(INTENT_TITLE, title));
    }
    public static void startActivity_single(Context context, String week, String title) {
        context.startActivity(new Intent(context, SubRankActivity.class)
                .putExtra(INTENT_WEEK, week)
                .putExtra(INTENT_TITLE, title));
    }
    private String week;
    private String month;
    private String all;
    private String title;

    @Bind(R.id.indicatorSubRank)
    RVPIndicator mIndicator;
    @Bind(R.id.viewpagerSubRank)
    ViewPager mViewPager;

    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;
    private List<String> mDatas;


    @Override
    public int getLayoutId() {
        return R.layout.activity_sub_rank;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFindComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        week = getIntent().getStringExtra(INTENT_WEEK);
        month = getIntent().getStringExtra(INTENT_MONTH);
        all = getIntent().getStringExtra(INTENT_ALL);

        title = getIntent().getStringExtra(INTENT_TITLE).split(" ")[0];
        mCommonToolbar.setTitle(title);
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        if(TextUtils.isEmpty(month)){
            mIndicator.setVisibility(View.GONE);
        }else{
            mDatas = Arrays.asList(getResources().getStringArray(R.array.sub_rank_tabs));
            mIndicator.setVisibility(View.VISIBLE);
        }

        mTabContents = new ArrayList<>();
        mTabContents.add(SubRankFragment.newInstance(week));
        if(!TextUtils.isEmpty(month)){
            mTabContents.add(SubRankFragment.newInstance(month));
        }
        if(!TextUtils.isEmpty(month)){
            mTabContents.add(SubRankFragment.newInstance(all));
        }


        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        if (mTabContents.size()>2){
            mViewPager.setOffscreenPageLimit(3);
        }else{
            mViewPager.setOffscreenPageLimit(0);
        }

        mIndicator.setViewPager(mViewPager, 0);
    }
}
