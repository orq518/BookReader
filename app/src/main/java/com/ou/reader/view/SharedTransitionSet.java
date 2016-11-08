package com.ou.reader.view;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;
import android.util.AttributeSet;


@TargetApi(Build.VERSION_CODES.KITKAT)
class SharedTransitionSet extends TransitionSet {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SharedTransitionSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SharedTransitionSet() {
        super();
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        setOrdering(ORDERING_TOGETHER);
        addTransition(new ChangeBounds()).
                addTransition(new ChangeTransform()).
                addTransition(new ChangeImageTransform());
    }
}
