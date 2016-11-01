package com.ou.reader.ui.easyadapter;

import android.content.Context;
import android.view.ViewGroup;

import com.ou.reader.R;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.CommentList;
import com.ou.reader.utils.FormatUtils;
import com.ou.reader.view.recyclerview.adapter.BaseViewHolder;
import com.ou.reader.view.recyclerview.adapter.RecyclerArrayAdapter;

/**
 * 帖子 评论、回复
 *
 * @author lfh.
 * @date 16/9/3.
 */
public class CommentListAdapter extends RecyclerArrayAdapter<CommentList.CommentsBean> {

    public CommentListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder<CommentList.CommentsBean>(parent, R.layout.item_comment_list) {
            @Override
            public void setData(CommentList.CommentsBean item) {
                holder.setCircleImageUrl(R.id.ivBookCover, Constant.IMG_BASE_URL + item.author.avatar, R.drawable.avatar_default)
                        .setText(R.id.tvBookTitle, item.author.nickname)
                        .setText(R.id.tvContent, item.content)
                        .setText(R.id.tvBookType, String.format(mContext.getString(R.string.book_detail_user_lv), item.author.lv))
                        .setText(R.id.tvFloor, String.format(mContext.getString(R.string.comment_floor), item.floor))
                        .setText(R.id.tvTime, FormatUtils.getDescriptionTimeFromDateString(item.created));

                if (item.replyTo == null) {
                    holder.setVisible(R.id.tvReplyNickName, false);
                    holder.setVisible(R.id.tvReplyFloor, false);
                } else {
                    holder.setText(R.id.tvReplyNickName, String.format(mContext.getString(R.string.comment_reply_nickname), item.replyTo.author.nickname))
                            .setText(R.id.tvReplyFloor, String.format(mContext.getString(R.string.comment_reply_floor), item.replyTo.floor));
                    holder.setVisible(R.id.tvReplyNickName, true);
                    holder.setVisible(R.id.tvReplyFloor, true);
                }
            }
        };
    }
}
