package com.ou.reader.ui.presenter;

import com.ou.reader.api.BookApi;
import com.ou.reader.base.RxPresenter;
import com.ou.reader.bean.DiscussionList;
import com.ou.reader.ui.contract.GirlBookDiscussionContract;
import com.ou.reader.utils.LogUtils;
import com.ou.reader.utils.RxUtil;
import com.ou.reader.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author lfh.
 * @date 16/9/8.
 */
public class GirlBookDiscussionPresenter extends RxPresenter<GirlBookDiscussionContract.View> implements GirlBookDiscussionContract.Presenter {

    private BookApi bookApi;

    @Inject
    public GirlBookDiscussionPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getGirlBookDisscussionList(String sort, String distillate, final int start, int limit) {
        String key = StringUtils.creatAcacheKey("girl-book-discussion-list", "girl", "all", sort, "all", start + "", limit + "", distillate);
        Observable<DiscussionList> fromNetWork = bookApi.getGirlBookDisscussionList("girl", "all", sort, "all", start + "", limit + "", distillate)
                .compose(RxUtil.<DiscussionList>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, DiscussionList.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscussionList>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("onError: " + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(DiscussionList list) {
                        boolean isRefresh = start == 0 ? true : false;
                        mView.showGirlBookDisscussionList(list.posts, isRefresh);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
