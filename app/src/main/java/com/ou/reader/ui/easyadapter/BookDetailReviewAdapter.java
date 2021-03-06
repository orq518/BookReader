package com.ou.reader.ui.easyadapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ou.reader.R;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.HotReview;
import com.ou.reader.utils.FormatUtils;
import com.ou.reader.view.XLHRatingBar;
import com.ou.reader.view.recyclerview.adapter.BaseViewHolder;
import com.ou.reader.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * @author lfh.
 * @date 16/9/3.
 */
public class BookDetailReviewAdapter extends RecyclerArrayAdapter<HotReview.Reviews> {


    public BookDetailReviewAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<HotReview.Reviews>(parent, R.layout.item_book_detai_hot_review_list) {
            @Override
            public void setData(HotReview.Reviews item) {
                holder.setCircleImageUrl(R.id.ivBookCover, Constant.IMG_BASE_URL + item.author.avatar, R.drawable.avatar_default)
                        .setText(R.id.tvBookTitle, item.author.nickname)
                        .setText(R.id.tvBookType, String.format(mContext.getString(R.string
                                .book_detail_user_lv), item.author.lv))
                        .setText(R.id.tvTime, FormatUtils.getDescriptionTimeFromDateString(item.created))
                        .setText(R.id.tvTitle, item.title)
                        .setText(R.id.tvContent, String.valueOf(item.content))
                        .setText(R.id.tvHelpfulYes, String.valueOf(item.helpful.yes));
                holder.setVisible(R.id.tvTime, true);
                XLHRatingBar ratingBar = holder.getView(R.id.rating);
                ratingBar.setCountSelected(item.rating);
            }
        };
    }
}
