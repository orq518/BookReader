package com.ou.reader.component;

import com.ou.reader.ui.activity.MainActivity;
import com.ou.reader.ui.fragment.BookcaseFragment;

import dagger.Component;

@Component(dependencies = AppComponent.class)
public interface MainComponent {
    MainActivity inject(MainActivity activity);

    BookcaseFragment inject(BookcaseFragment fragment);
}