package com.ou.reader.view.loadding;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ou.reader.R;

public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        this(context, 0);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static CustomDialog instance(Activity activity) {
        LoadingView v = (LoadingView) View.inflate(activity, R.layout.common_progress_view, null);
        v.setColor(ContextCompat.getColor(activity, R.color.light_blue));
        CustomDialog dialog = new CustomDialog(activity, R.style.loading_dialog);
        dialog.setContentView(v,
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT)
        );
        return dialog;
    }
    public static CustomDialog instance1(Activity activity) {
        RelativeLayout v = (RelativeLayout) View.inflate(activity, R.layout.common_progress_point_view, null);
        CustomDialog dialog = new CustomDialog(activity, R.style.loading_dialog);
        dialog.setContentView(v,
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT)
        );
        return dialog;
    }
}
