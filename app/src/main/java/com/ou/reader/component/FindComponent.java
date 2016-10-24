package com.ou.reader.component;

import com.ou.reader.ui.activity.SubCategoryListActivity;
import com.ou.reader.ui.activity.SubRankActivity;
import com.ou.reader.ui.activity.SubjectBookListActivity;
import com.ou.reader.ui.activity.SubjectBookListDetailActivity;
import com.ou.reader.ui.activity.TopCategoryListActivity;
import com.ou.reader.ui.activity.TopRankActivity;
import com.ou.reader.ui.fragment.BookCommentsFragment;
import com.ou.reader.ui.fragment.BookStoreChildFragment;
import com.ou.reader.ui.fragment.BookStoreFragment;
import com.ou.reader.ui.fragment.HotBookListFragment;
import com.ou.reader.ui.fragment.SubCategoryFragment;
import com.ou.reader.ui.fragment.SubRankFragment;
import com.ou.reader.ui.fragment.SubjectFragment;

import dagger.Component;

/**
 * @author yuyh.
 * @date 16/9/1.
 */
@Component(dependencies = AppComponent.class)
public interface FindComponent {

    /** 分类 **/
    TopCategoryListActivity inject(TopCategoryListActivity activity);

    SubCategoryListActivity inject(SubCategoryListActivity activity);

    SubCategoryFragment inject(SubCategoryFragment fragment);

    /** 排行 **/
    TopRankActivity inject(TopRankActivity activity);

    SubRankActivity inject(SubRankActivity activity);

    SubRankFragment inject(SubRankFragment fragment);

    /** 主题书单 **/
    SubjectBookListActivity inject(SubjectBookListActivity subjectBookListActivity);

    SubjectFragment inject(SubjectFragment subjectFragment);

    SubjectBookListDetailActivity inject(SubjectBookListDetailActivity categoryListActivity);

    HotBookListFragment inject(HotBookListFragment hotBookListFragment);
    BookStoreFragment inject(BookStoreFragment bookStoreFragment);
    BookCommentsFragment inject(BookCommentsFragment bookCommentsFragment);
    BookStoreChildFragment inject(BookStoreChildFragment bookStoreChildFragment);
}
