package com.ou.reader.component;

import com.ou.reader.ui.activity.BookDetailActivity;
import com.ou.reader.ui.activity.BooksByTagActivity;
import com.ou.reader.ui.activity.ReadActivity;
import com.ou.reader.ui.activity.SearchActivity;
import com.ou.reader.ui.activity.SearchByAuthorActivity;
import com.ou.reader.ui.fragment.BookDetailDiscussionFragment;
import com.ou.reader.ui.fragment.BookDetailReviewFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface BookComponent {
    BookDetailActivity inject(BookDetailActivity activity);

    ReadActivity inject(ReadActivity activity);

    BooksByTagActivity inject(BooksByTagActivity activity);

    SearchActivity inject(SearchActivity activity);

    SearchByAuthorActivity inject(SearchByAuthorActivity activity);

    BookDetailReviewFragment inject(BookDetailReviewFragment fragment);

    BookDetailDiscussionFragment inject(BookDetailDiscussionFragment fragment);
}