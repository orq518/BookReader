package com.ou.reader.view;

/**
 * The author ou on 2016/3/15.
 * todo 定义gridview，解决ScrollView中嵌套gridview显示不正常的问题（1行半）
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyGridView extends GridView {
    private int type;
    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setType(int type) {
        this.type = type;

    }
    public int getType() {
       return type;
    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                xDistance = yDistance = 0f;
//                xLast = event.getX();
//                yLast = event.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                final float curX = event.getX();
//                final float curY = event.getY();
//
//                xDistance += Math.abs(curX - xLast);
//                yDistance += Math.abs(curY - yLast);
//
//                xLast = curX;
//                yLast = curY;
//
//                break;
//            case MotionEvent.ACTION_UP:
//                if (xDistance>50||yDistance>50){
//                    return true;
//                }
//                break;
//        }
//        return super.onTouchEvent(event);
//    }
    float xDistance, yDistance, xLast, yLast;

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}