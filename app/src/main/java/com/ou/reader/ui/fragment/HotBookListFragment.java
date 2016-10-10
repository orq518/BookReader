package com.ou.reader.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.ou.reader.R;
import com.ou.reader.base.BaseFragment;
import com.ou.reader.bean.BookListTags;
import com.ou.reader.bean.support.TagEvent;
import com.ou.reader.common.OnRvItemClickListener;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerFindComponent;
import com.ou.reader.ui.activity.MainActivity;
import com.ou.reader.ui.adapter.SubjectTagsAdapter;
import com.ou.reader.ui.contract.SubjectBookListContract;
import com.ou.reader.ui.presenter.SubjectBookListPresenter;
import com.ou.reader.utils.ToastUtils;
import com.ou.reader.view.RVPIndicator;
import com.ou.reader.view.ReboundScrollView;
import com.ou.reader.view.SupportDividerItemDecoration;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * author：ou on 2016/10/8 14:39
 * todo
 */
public class HotBookListFragment extends BaseFragment implements SubjectBookListContract.View, OnRvItemClickListener<String> {

    @Bind(R.id.indicatorSubject)
    RVPIndicator mIndicator;
    @Bind(R.id.viewpagerSubject)
    ViewPager mViewPager;
    @Bind(R.id.rsvTags)
    ReboundScrollView rsvTags;

    @Bind(R.id.rvTags)
    RecyclerView rvTags;
    private SubjectTagsAdapter mTagAdapter;
    private List<BookListTags.DataBean> mTagList = new ArrayList<>();

    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;
    private List<String> mDatas;

    @Inject
    SubjectBookListPresenter mPresenter;

    MainActivity mActivity;
    private FragmentManager fm;
    private String currentTag = "";
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_subject_book_list_tag;
    }

    @Override
    public void initDatas() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.subject_tabs));
        mTabContents = new ArrayList<>();
        mTabContents.add(SubjectFragment.newInstance("", 0));
        mTabContents.add(SubjectFragment.newInstance("", 1));
        mTabContents.add(SubjectFragment.newInstance("", 2));

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

        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager, 0);

        rvTags.setHasFixedSize(true);
        rvTags.setLayoutManager(new LinearLayoutManager(mActivity));
        rvTags.addItemDecoration(new SupportDividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL));
        mTagAdapter = new SubjectTagsAdapter(mActivity, mTagList);
        mTagAdapter.setItemClickListener(this);
        rvTags.setAdapter(mTagAdapter);
//        Log.e("ouou","mPresenter:"+mPresenter);
        if(mPresenter!=null) {
        mPresenter.attachView(this);
        mPresenter.getBookListTags();
        }
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
    public void attachView() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_tags) {
            if (isVisible(rsvTags)) {
                hideTagGroup();
            } else {
                showTagGroup();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position, String data) {
        hideTagGroup();
        currentTag = data;
        EventBus.getDefault().post(new TagEvent(currentTag));
    }

    @Override
    public void showBookListTags(BookListTags data) {
        mTagList.clear();
        mTagList.addAll(data.data);
        mTagAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
    private void showTagGroup() {
        if (mTagList.isEmpty()) {
            ToastUtils.showToast(getString(R.string.network_error_tips));
            return;
        }
        Animation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(400);
        rsvTags.startAnimation(mShowAction);
        rsvTags.setVisibility(View.VISIBLE);
    }

    private void hideTagGroup() {
        Animation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, -1.0f);
        mHiddenAction.setDuration(400);
        rsvTags.startAnimation(mHiddenAction);
        rsvTags.setVisibility(View.GONE);
    }

}
