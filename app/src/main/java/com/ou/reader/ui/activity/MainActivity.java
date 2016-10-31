/**
 * Copyright (c) 2016, smuyyh@gmail.com All Rights Reserved.
 * #                                                   #
 * #                       _oo0oo_                     #
 * #                      o8888888o                    #
 * #                      88" . "88                    #
 * #                      (| -_- |)                    #
 * #                      0\  =  /0                    #
 * #                    ___/`---'\___                  #
 * #                  .' \\|     |# '.                 #
 * #                 / \\|||  :  |||# \                #
 * #                / _||||| -:- |||||- \              #
 * #               |   | \\\  -  #/ |   |              #
 * #               | \_|  ''\---/''  |_/ |             #
 * #               \  .-\__  '-'  ___/-. /             #
 * #             ___'. .'  /--.--\  `. .'___           #
 * #          ."" '<  `.___\_<|>_/___.' >' "".         #
 * #         | | :  `- \`.;`\ _ /`;.`/ - ` : | |       #
 * #         \  \ `_.   \_ __\ /__ _/   .-` /  /       #
 * #     =====`-.____`.___ \_____/___.-`___.-'=====    #
 * #                       `=---='                     #
 * #     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   #
 * #                                                   #
 * #               佛祖保佑         永无BUG             #
 * #                                                   #
 */
package com.ou.reader.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.ou.reader.R;
import com.ou.reader.base.BaseActivity;
import com.ou.reader.base.BaseFragment;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.user.TencentLoginResult;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerMainComponent;
import com.ou.reader.service.DownloadBookService;
import com.ou.reader.ui.contract.MainContract;
import com.ou.reader.ui.fragment.BookCaseFragment;
import com.ou.reader.ui.fragment.BookCommentsFragment;
import com.ou.reader.ui.fragment.BookStoreFragment;
import com.ou.reader.ui.fragment.HotBookListFragment;
import com.ou.reader.ui.presenter.MainActivityPresenter;
import com.ou.reader.utils.LogUtils;
import com.ou.reader.utils.SharedPreferencesUtil;
import com.ou.reader.utils.ToastUtils;
import com.ou.reader.view.LoginPopupWindow;
import com.ou.reader.view.TabWidgetLayout;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

import java.lang.reflect.Method;

import javax.inject.Inject;

/**
 * https://github.com/JustWayward/BookReader
 */
public class MainActivity extends BaseActivity implements MainContract.View, LoginPopupWindow.LoginTypeListener,
        TabWidgetLayout.OnTabSelectedListener {

    @Inject
    MainActivityPresenter mPresenter;

    // 退出时间
    private long currentBackPressedTime = 0;
    // 退出间隔
    private static final int BACK_PRESSED_INTERVAL = 2000;

    private LoginPopupWindow popupWindow;
    public static Tencent mTencent;
    public IUiListener loginListener;
    private FragmentManager fm;

    BookCaseFragment mBookCaseFragment;
    BookStoreFragment mBookStoreFragment;
    HotBookListFragment mHotBookListFragment;
//    CommunityFragment mCommunityFragment;
    BookCommentsFragment mBookCommentsFragment;
    private TabWidgetLayout mTabWidget;
    Menu mMenu;
    BaseFragment curFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, DownloadBookService.class));
        fm = getSupportFragmentManager();
        initDatas();
        configViews();
        initTabs();
        mTencent = Tencent.createInstance("1105670298", MainActivity.this);
    }

    public void initTabs() {
        mTabWidget = (TabWidgetLayout) findViewById(R.id.tab_widget);
        mTabWidget.setOnTabSelectedListener(this);
        showFragment(0);
        mTabWidget.setTabsDisplay(this, 0);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setLogo(R.drawable.left_icon);
        setTitle("");
    }

    @Override
    public void initDatas() {
    }

    @Override
    public void configViews() {
        mPresenter.attachView(this);
    }

    public void setCurrentItem(int position) {
        showFragment(position);
        mTabWidget.setTabsDisplay(this, position);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mMenu = menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_all_comment:
                BookDiscussionActivity.startActivity(this);
                break;
            case R.id.menu_rank:
                mBookStoreFragment.onOptionsItemSelected(item);
                break;
            case R.id.menu_tags:
                mHotBookListFragment.onOptionsItemSelected(item);
                break;
            case R.id.action_search:
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
                break;
//            case R.id.action_login:
//                if (popupWindow == null) {
//                    popupWindow = new LoginPopupWindow(this);
//                    popupWindow.setLoginTypeListener(this);
//                }
//                popupWindow.showAtLocation(mCommonToolbar, Gravity.CENTER, 0, 0);
//                break;
//            case R.id.action_my_message:
//                break;
//            case R.id.action_sync_bookshelf:
//                break;
//            case R.id.action_scan_local_book:
//                break;
//            case R.id.action_wifi_book:
//                break;
//            case R.id.action_feedback:
//                break;
            case R.id.action_night_mode:
                if (SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT, false)) {
                    SharedPreferencesUtil.getInstance().putBoolean(Constant.ISNIGHT, false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    SharedPreferencesUtil.getInstance().putBoolean(Constant.ISNIGHT, true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
                break;
//            case R.id.action_settings:
//                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {

                if (curFragment!=null&&curFragment.goback()){
                    return true;
                }


            if (System.currentTimeMillis() - currentBackPressedTime > BACK_PRESSED_INTERVAL) {
                currentBackPressedTime = System.currentTimeMillis();
                ToastUtils.showToast(getString(R.string.exit_tips));
                return true;
            } else {
                finish(); // 退出
            }
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 显示item中的图片；
     *
     * @param view
     * @param menu
     * @return
     */
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, DownloadBookService.class));
    }

    @Override
    public void loginSuccess() {
        ToastUtils.showSingleToast("登陆成功");
    }

    @Override
    public void onLogin(ImageView view, String type) {
        if (type.equals("QQ")) {
            if (!mTencent.isSessionValid()) {
                if (loginListener == null) loginListener = new BaseUIListener();
                mTencent.login(this, "all", loginListener);
            }
        }
        //4f45e920ff5d1a0e29d997986cd97181
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onTabSelected(int index, int from) {
        showFragment(index);
    }

    private void showFragment(int position) {
        FragmentTransaction ft = fm.beginTransaction();
        hideAllFragment(ft);
        if (mMenu != null) {
            mMenu.clear();
        }
        switch (position) {
            case 0:
                if (mBookCaseFragment != null) {
                    ft.show(mBookCaseFragment);
                } else {
                    mBookCaseFragment = new BookCaseFragment();
                    ft.add(R.id.frame_layout, mBookCaseFragment);
                }
                if (mMenu != null) {
                    getMenuInflater().inflate(R.menu.menu_main, mMenu);
                }
                curFragment= mBookCaseFragment;
                break;
            case 1:
                if (mBookStoreFragment != null) {
                    ft.show(mBookStoreFragment);
                } else {
                    mBookStoreFragment = new BookStoreFragment();
                    ft.add(R.id.frame_layout, mBookStoreFragment);
                }
                if (mMenu != null) {
                    getMenuInflater().inflate(R.menu.menu_ranking, mMenu);
                }
                curFragment=mBookStoreFragment;
                break;
            case 2:
                if (mHotBookListFragment != null) {
                    ft.show(mHotBookListFragment);
                } else {
                    mHotBookListFragment = new HotBookListFragment();
                    ft.add(R.id.frame_layout, mHotBookListFragment);
                }
                if (mMenu != null) {
                    getMenuInflater().inflate(R.menu.menu_subject_fragment, mMenu);
                }
                curFragment=mHotBookListFragment;
                break;

            case 3:
                if (mBookCommentsFragment != null) {
                    ft.show(mBookCommentsFragment);
                } else {
                    mBookCommentsFragment = new BookCommentsFragment();
                    ft.add(R.id.frame_layout, mBookCommentsFragment);
                }
                if (mMenu != null) {
                    getMenuInflater().inflate(R.menu.menu_comment, mMenu);
                }
                curFragment=mBookCommentsFragment;
                break;
        }
        ft.commit();
    }

    private void hideAllFragment(FragmentTransaction ft) {
        if (mBookCaseFragment != null) {
            ft.hide(mBookCaseFragment);
        }
        if (mBookCommentsFragment != null) {
            ft.hide(mBookCommentsFragment);
        }
        if (mBookStoreFragment != null) {
            ft.hide(mBookStoreFragment);
        }
        if (mHotBookListFragment != null) {
            ft.hide(mHotBookListFragment);
        }
    }

    public class BaseUIListener implements IUiListener {

        @Override
        public void onComplete(Object o) {
            JSONObject jsonObject = (JSONObject) o;
            String json = jsonObject.toString();
            Gson gson = new Gson();
            TencentLoginResult result = gson.fromJson(json, TencentLoginResult.class);
            LogUtils.e(result.toString());
            mPresenter.login(result.openid, result.access_token, "QQ");
        }

        @Override
        public void onError(UiError uiError) {
        }

        @Override
        public void onCancel() {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN || requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}