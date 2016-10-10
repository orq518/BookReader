package com.ou.reader.component;

import com.ou.reader.ui.activity.BookDiscussionDetailActivity;
import com.ou.reader.ui.activity.BookHelpDetailActivity;
import com.ou.reader.ui.activity.BookReviewDetailActivity;
import com.ou.reader.ui.fragment.BookDiscussionFragment;
import com.ou.reader.ui.fragment.BookHelpFragment;
import com.ou.reader.ui.fragment.BookReviewFragment;
import com.ou.reader.ui.fragment.GirlBookDiscussionFragment;

import dagger.Component;

/**
 * @author yuyh.
 * @date 16/9/2.
 */
@Component(dependencies = AppComponent.class)
public interface CommunityComponent {

    BookDiscussionFragment inject(BookDiscussionFragment fragment);

    BookDiscussionDetailActivity inject(BookDiscussionDetailActivity activity);

    BookReviewFragment inject(BookReviewFragment fragment);

    BookReviewDetailActivity inject(BookReviewDetailActivity activity);

    BookHelpFragment inject(BookHelpFragment fragment);

    BookHelpDetailActivity inject(BookHelpDetailActivity activity);

    GirlBookDiscussionFragment inject(GirlBookDiscussionFragment fragment);
}
