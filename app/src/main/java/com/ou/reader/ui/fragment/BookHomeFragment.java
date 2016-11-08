package com.ou.reader.ui.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cleveroad.fanlayoutmanager.FanLayoutManager;
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings;
import com.cleveroad.fanlayoutmanager.callbacks.FanChildDrawingOrderCallback;
import com.ou.reader.R;
import com.ou.reader.api.net.BookNet;
import com.ou.reader.base.BaseFragment;
import com.ou.reader.bean.Recommend;
import com.ou.reader.component.AppComponent;
import com.ou.reader.ui.adapter.SportCardsAdapter;
import com.ou.reader.utils.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author：ou on 2016/10/8 14:39
 * todo
 */
public class BookHomeFragment extends BaseFragment {


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    public void initDatas() {
        getMaleRecommend();
        getFemaleRecommend();
    }


    @Override
    public void configViews() {

    }

    @Override
    public boolean goback() {
        return false;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    }

    @Override
    public void attachView() {
    }
    FanLayoutManagerSettings fanLayoutManagerSettings;

    private FanLayoutManager maleFanLayoutManager;
    private SportCardsAdapter maleAdapter;
    RecyclerView maleRecyclerView;



    private FanLayoutManager feMaleFanLayoutManager;
    private SportCardsAdapter feMaleAdapter;
    RecyclerView feMaleRecyclerView;
    public static BookHomeFragment newInstance() {
        BookHomeFragment fragment = new BookHomeFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fanLayoutManagerSettings = FanLayoutManagerSettings
                .newBuilder(getContext())
                .withFanRadius(false)
                .withAngleItemBounce(5)
                .build();
        maleRecyclerView = (RecyclerView) view.findViewById(R.id.rvCards);
        maleFanLayoutManager = new FanLayoutManager(getContext(), fanLayoutManagerSettings);
        maleRecyclerView.setLayoutManager(maleFanLayoutManager);
        maleRecyclerView.setItemAnimator(new DefaultItemAnimator());
        maleAdapter = new SportCardsAdapter(getContext());
        maleAdapter.setItemClickListener(new SportCardsAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, final View view) {
                if (maleFanLayoutManager.getSelectedItemPosition() != itemPosition) {
                    maleFanLayoutManager.switchItem(maleRecyclerView, itemPosition);
                } else {
//                    fanLayoutManager.straightenSelectedItem(new Animator.AnimatorListener() {
//                        @Override
//                        public void onAnimationStart(Animator animator) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animator animator) {
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                onClick(view, fanLayoutManager.getSelectedItemPosition());
//                            } else {
//                                onClick(fanLayoutManager.getSelectedItemPosition());
//                            }
//                        }
//
//                        @Override
//                        public void onAnimationCancel(Animator animator) {
//
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animator animator) {
//
//                        }
//                    });
                }
            }
        });
        maleRecyclerView.setAdapter(maleAdapter);
        maleRecyclerView.setChildDrawingOrderCallback(new FanChildDrawingOrderCallback(maleFanLayoutManager));

        feMaleFanLayoutManager = new FanLayoutManager(getContext(), fanLayoutManagerSettings);
        feMaleRecyclerView = (RecyclerView) view.findViewById(R.id.rvCards1);
        feMaleRecyclerView.setLayoutManager(feMaleFanLayoutManager);
        feMaleRecyclerView.setItemAnimator(new DefaultItemAnimator());
        feMaleAdapter = new SportCardsAdapter(getContext());
        feMaleAdapter.setItemClickListener(new SportCardsAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, final View view) {
                if (feMaleFanLayoutManager.getSelectedItemPosition() != itemPosition) {
                    feMaleFanLayoutManager.switchItem(feMaleRecyclerView, itemPosition);
                } else {
//                    fanLayoutManager.straightenSelectedItem(new Animator.AnimatorListener() {
//                        @Override
//                        public void onAnimationStart(Animator animator) {
//
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animator animator) {
//                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                onClick(view, fanLayoutManager.getSelectedItemPosition());
//                            } else {
//                                onClick(fanLayoutManager.getSelectedItemPosition());
//                            }
//                        }
//
//                        @Override
//                        public void onAnimationCancel(Animator animator) {
//
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animator animator) {
//
//                        }
//                    });
                }
            }
        });
        feMaleRecyclerView.setAdapter(feMaleAdapter);
        feMaleRecyclerView.setChildDrawingOrderCallback(new FanChildDrawingOrderCallback(feMaleFanLayoutManager));
//        (view.findViewById(R.id.logo)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fanLayoutManager.collapseViews();
//            }
//        });

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void onClick(View view, int pos) {
        LogUtils.d("pos11:" + pos);
//        FullInfoTabFragment fragment = FullInfoTabFragment.newInstance(adapter.getModelByPos(pos));
//
//        fragment.setSharedElementEnterTransition(new SharedTransitionSet());
//        fragment.setEnterTransition(new Fade());
//        setExitTransition(new Fade());
//        fragment.setSharedElementReturnTransition(new SharedTransitionSet());
//
//        getActivity().getSupportFragmentManager()
//                .beginTransaction()
//                .addSharedElement(view, "shared")
//                .replace(R.id.root, fragment)
//                .addToBackStack(null)
//                .commit();
    }

    public void onClick(int pos) {
        LogUtils.d("pos22:" + pos);
//        FullInfoTabFragment fragment = FullInfoTabFragment.newInstance(adapter.getModelByPos(pos));
//        getActivity().getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.root, fragment)
//                .addToBackStack(null)
//                .commit();
    }

    public boolean deselectIfSelected() {
        if (maleFanLayoutManager.isItemSelected()) {
            maleFanLayoutManager.deselectItem();
            return true;
        } else {
            return false;
        }
    }

    public void getMaleRecommend() {
        Call<Recommend> call = BookNet.getInstance().getService().getRecomend("male");
        //异步请求
        call.enqueue(new Callback<Recommend>() {
            @Override
            public void onResponse(Call<Recommend> call, Response<Recommend> response) {
                Recommend repos = response.body();
                if(repos!=null&&repos.books!=null&&repos.books.size()>0) {
                    LogUtils.d("repos.books.size():" + repos.books.size());
                    maleAdapter.setData(repos.books);
                }
            }

            @Override
            public void onFailure(Call<Recommend> call, Throwable t) {

            }

        });
    }
    public void getFemaleRecommend() {
        Call<Recommend> call = BookNet.getInstance().getService().getRecomend("female");
        //异步请求
        call.enqueue(new Callback<Recommend>() {
            @Override
            public void onResponse(Call<Recommend> call, Response<Recommend> response) {
                Recommend repos = response.body();
                if(repos!=null&&repos.books!=null&&repos.books.size()>0) {
                    LogUtils.d("repos.books.size():" + repos.books.size());
                    feMaleAdapter.setData(repos.books);
                }
            }

            @Override
            public void onFailure(Call<Recommend> call, Throwable t) {

            }

        });
    }
}
