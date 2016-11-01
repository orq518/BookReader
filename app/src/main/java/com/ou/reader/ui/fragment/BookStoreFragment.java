package com.ou.reader.ui.fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.ou.reader.R;
import com.ou.reader.base.BaseFragment;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.CategoryList;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerFindComponent;
import com.ou.reader.ui.activity.MainActivity;
import com.ou.reader.ui.activity.SubCategoryListActivity;
import com.ou.reader.ui.activity.TopRankActivity;
import com.ou.reader.ui.adapter.BookStoreAdapter;
import com.ou.reader.ui.contract.TopCategoryListContract;
import com.ou.reader.ui.presenter.TopCategoryListPresenter;
import com.ou.reader.utils.Constants;
import com.ou.reader.utils.DataTools;
import com.ou.reader.view.MyGridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * author：ou on 2016/10/8 14:39
 * todo
 */
public class BookStoreFragment extends BaseFragment implements TopCategoryListContract.View  {

    @Bind(R.id.male_books)
    MyGridView mMaleGridView;
    @Bind(R.id.female_books)
    MyGridView femaleBooksGridView;
    @Inject
    TopCategoryListPresenter mPresenter;
    BookStoreAdapter maleAdapter;
    BookStoreAdapter famaleAdapter;
    private List<CategoryList.MaleBean> mMaleCategoryList = new ArrayList<>();
    private List<CategoryList.MaleBean> mFemaleCategoryList = new ArrayList<>();

    MainActivity mActivity;
    ItemClickListener mMaleItemClickListener;
    ItemClickListener mFamaleItemClickListener;


    CategoryList mCategoryList;
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_top_category_list;
    }

    @Override
    public void initDatas() {
        mCategoryList = (CategoryList) DataTools.readData(mContext, Constants.KEY_BOOK_STORE);
    }


    @Override
    public void configViews() {

        showDialog();
        mMaleItemClickListener=new ItemClickListener(1);
        mFamaleItemClickListener=new ItemClickListener(2);
        mPresenter.attachView(this);
        mPresenter.getCategoryList();

        maleAdapter =new BookStoreAdapter(mContext);
        mMaleGridView.setAdapter(maleAdapter);
        famaleAdapter =new BookStoreAdapter(mContext);
        femaleBooksGridView.setAdapter(famaleAdapter);

        mMaleGridView.setOnItemClickListener(mMaleItemClickListener);
        femaleBooksGridView.setOnItemClickListener(mFamaleItemClickListener);
        if(mCategoryList!=null){
            showCategoryList(mCategoryList);
        }
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

        if (mCategoryList!=null){
            maleAdapter.setLastData((ArrayList<CategoryList.MaleBean>) mCategoryList.male);
            famaleAdapter.setLastData((ArrayList<CategoryList.MaleBean>)mCategoryList.female);
        }
        maleAdapter.setData((ArrayList<CategoryList.MaleBean>) mMaleCategoryList);
        famaleAdapter.setData((ArrayList<CategoryList.MaleBean>) mFemaleCategoryList);

        try {
            DataTools.writeData(mActivity, data, Constants.KEY_BOOK_STORE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ItemClickListener implements AdapterView.OnItemClickListener {
        int type;
        public ItemClickListener( int type){
            this.type=type;
        }
//        private String gender;
//
//        public ClickListener(@Constant.Gender String gender) {
//            this.gender = gender;
//        }
//
//        @Override
//        public void onItemClick(View view, int position, CategoryList.MaleBean data) {
//            SubCategoryListActivity.startActivity(mActivity, data.name, gender);
//        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (type==1){
                SubCategoryListActivity.startActivity(mActivity, mMaleCategoryList.get(position).name, Constant.Gender.MALE);
            }else{
                SubCategoryListActivity.startActivity(mActivity,mFemaleCategoryList.get(position).name, Constant.Gender.FEMALE);
            }
        }
    }
}
