package com.ou.reader.ui.fragment;

import android.view.MenuItem;

import com.ou.reader.R;
import com.ou.reader.base.BaseFragment;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.support.SelectionEvent;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerFindComponent;
import com.ou.reader.ui.activity.MainActivity;
import com.ou.reader.ui.activity.TopRankActivity;
import com.ou.reader.view.SelectionLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * author：ou on 2016/10/8 14:39
 * todo
 */
public class BookCommentsFragment extends BaseFragment  implements SelectionLayout.OnSelectListener {


    MainActivity mActivity;


    @Bind(R.id.slOverall)
    SelectionLayout slOverall;

    protected List<List<String>> list;

    protected List<List<String>> list1 = new ArrayList<List<String>>() {{
        add(new ArrayList<String>() {{
            add("全部");
            add("精品");
        }});
        add(new ArrayList<String>() {{
            add("默认排序");
            add("最新发布");
            add("最多评论");
        }});
    }};

    protected List<List<String>> list2 = new ArrayList<List<String>>() {{
        add(new ArrayList<String>() {{
            add("全部");
            add("精品");
        }});
        add(new ArrayList<String>() {{
            add("全部类型");
            add("玄幻奇幻");
            add("武侠仙侠");
            add("都市异能");
            add("历史军事");
            add("游戏竞技");
            add("科幻灵异");
            add("穿越架空");
            add("豪门总裁");
            add("现代言情");
            add("古代言情");
            add("幻想言情");
            add("耽美同人");
        }});
        add(new ArrayList<String>() {{
            add("默认排序");
            add("最新发布");
            add("最多评论");
            add("最有用的");
        }});
    }};

    @Constant.Distillate
    private String distillate = Constant.Distillate.ALL;
    @Constant.BookType
    private String type = Constant.BookType.ALL;
    @Constant.SortType
    private String sort = Constant.SortType.DEFAULT;
    @Override
    public int getLayoutResId() {
        return R.layout.activity_community_book_review;
    }

    @Override
    public void initDatas() {
        list = list2;
        if (slOverall != null) {
            slOverall.setData(list.toArray(new List[list.size()]));
            slOverall.setOnSelectListener(this);
        }
    }


    @Override
    public void configViews() {

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        mActivity= (MainActivity) getActivity();
        DaggerFindComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_rank) {
            TopRankActivity.startActivity(mActivity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void attachView() {
    }
    @SuppressWarnings("WrongConstant")
    @Override
    public void onSelect(int index, int position, String title) {
        switch (index) {
            case 0:
                switch (position) {
                    case 0:
                        distillate = "";
                        break;
                    case 1:
                        distillate = "true";
                        break;
                    default:
                        break;
                }
                break;
            case 1:
                if (list.size() == 2) {
                    sort = Constant.sortTypeList.get(position);
                } else if (list.size() == 3) {
                    type = Constant.bookTypeList.get(position);
                }
                break;
            case 2:
                sort = Constant.sortTypeList.get(position);
                break;
            default:
                break;
        }

        EventBus.getDefault().post(new SelectionEvent(distillate, type, sort));
    }
}
