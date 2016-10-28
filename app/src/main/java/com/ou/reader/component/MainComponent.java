package com.ou.reader.component;

import com.ou.reader.ui.activity.MainActivity;
import com.ou.reader.ui.fragment.BookCaseFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface MainComponent {
    MainActivity inject(MainActivity activity);

    BookCaseFragment inject(BookCaseFragment fragment);
}