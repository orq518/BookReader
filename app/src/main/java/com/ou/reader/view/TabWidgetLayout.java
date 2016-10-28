package com.ou.reader.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.ou.reader.R;

import java.util.ArrayList;
import java.util.List;

/**
 * The author 欧瑞强 on 2015/7/16.
 * todo 首頁底部TAB控件
 */
public class TabWidgetLayout extends LinearLayout {


    // 存放底部菜单的各个文字CheckedTextView
    private List<CheckedTextView> mCheckedList = new ArrayList<CheckedTextView>();
    // 存放底部菜单每项View
    private List<CheckedTextView> mIconCheckedList = new ArrayList<CheckedTextView>();
    // 存放底部菜单每项View
    private List<View> mViewList = new ArrayList<View>();

    // 底部菜单的文字数组
    private String[] mLabels= new String[]{"书架", "推荐", "书库", "书评"};
    Context mContext;
    int height;
    public int TOUCH = 0, ONRESUME = 1;
    public int  tabSelected;

    /**
     * 底部的icon
     */
    private int[] mDrawableIds = new int[]{R.drawable.home_tab0,
            R.drawable.home_tab1, R.drawable.home_tab2,
            R.drawable.home_tab3};
    public TabWidgetLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // 初始化控件
        init(context);
    }

    public TabWidgetLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabWidgetLayout(Context context) {
        super(context);
        init(context);
    }

    /**
     * 初始化控件
     */
    private void init(final Context context) {
        mContext = context;
        this.setOrientation(LinearLayout.HORIZONTAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        int size = mLabels.length;
        for (int i = 0; i < size; i++) {
            final int index = i;
            // 每个tab对应的layout
            RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.tab_item, null);
            CheckedTextView itemName = (CheckedTextView) view.findViewById(R.id.item_name);
            CheckedTextView itemIcon = (CheckedTextView) view.findViewById(R.id.item_icon);
            itemIcon.setBackgroundResource(mDrawableIds[i]);
            itemName.setText(mLabels[i]);

            // 指示点ImageView，如有版本更新需要显示
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1.0f);
            params.gravity = Gravity.CENTER;
            this.addView(view, params);
            // CheckedTextView设置索引作为tag，以便后续更改颜色、图片等
            itemName.setTag(index);
            // 将CheckedTextView添加到list中，便于操作
            mIconCheckedList.add(itemIcon);
            mCheckedList.add(itemName);

            // 将各个tab的View添加到list
            mViewList.add(view);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 设置底部图片和文字的显示
                    setTabsDisplay(context, index);
                    if (null != mTabListener) {
                        // tab项被选中的回调事件
                        mTabListener.onTabSelected(index,TOUCH);
                    }
                }
            });

        }
        setTabsDisplay(mContext, 0);
    }


    /**
     * 设置底部导航中图片显示状态和字体颜色
     */
    public void setTabsDisplay(Context context, int index) {
        int size = mCheckedList.size();
        for (int i = 0; i < size; i++) {
            CheckedTextView checkedTextView = mCheckedList.get(i);
            CheckedTextView checkedIcon = mIconCheckedList.get(i);

            if ((Integer) (checkedTextView.getTag()) == index) {
                checkedTextView.setChecked(true);
                checkedIcon.setChecked(true);
                checkedTextView.setTextColor(mContext.getResources().getColor(R.color.light_blue));//#F7587B
//                mViewList.get(i).setBackgroundColor(mContext.getResources().getColor(R.color.white));//#F0F1F2
            } else {
                checkedTextView.setChecked(false);
                checkedIcon.setChecked(false);
                checkedTextView.setTextColor(mContext.getResources().getColor(R.color.text_gray));//#130C0E
//                mViewList.get(i).setBackgroundColor(mContext.getResources().getColor(R.color.white));//#FAFAFA
            }
        }
    }


    // 回调接口，用于获取tab的选中状态
    private OnTabSelectedListener mTabListener;

    public interface OnTabSelectedListener {
        void onTabSelected(int index, int from);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener listener) {
        this.mTabListener = listener;
    }

}
