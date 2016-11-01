package com.ou.reader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ou.reader.R;
import com.ou.reader.base.BaseRVActivity;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.CommentList;
import com.ou.reader.bean.BookHelp;
import com.ou.reader.common.OnRvItemClickListener;
import com.ou.reader.component.AppComponent;
import com.ou.reader.component.DaggerCommunityComponent;
import com.ou.reader.ui.adapter.BestCommentListAdapter;
import com.ou.reader.ui.contract.BookHelpDetailContract;
import com.ou.reader.ui.easyadapter.CommentListAdapter;
import com.ou.reader.ui.presenter.BookHelpDetailPresenter;
import com.ou.reader.utils.FormatUtils;
import com.ou.reader.view.BookContentTextView;
import com.ou.reader.view.SupportDividerItemDecoration;
import com.ou.reader.view.recyclerview.adapter.RecyclerArrayAdapter;
import com.yuyh.easyadapter.glide.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 书荒互助区详情
 */
public class BookHelpDetailActivity extends BaseRVActivity<CommentList.CommentsBean> implements BookHelpDetailContract.View, OnRvItemClickListener<CommentList.CommentsBean> {

    private static final String INTENT_ID = "id";

    public static void startActivity(Context context, String id) {
        context.startActivity(new Intent(context, BookHelpDetailActivity.class)
                .putExtra(INTENT_ID, id));
    }

    private String id;

    @Inject
    BookHelpDetailPresenter mPresenter;

    private List<CommentList.CommentsBean> mBestCommentList = new ArrayList<>();
    private BestCommentListAdapter mBestCommentListAdapter;

    private HeaderViewHolder headerViewHolder;

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    static class HeaderViewHolder {
        @Bind(R.id.ivBookCover)
        ImageView ivAvatar;
        @Bind(R.id.tvBookTitle)
        TextView tvNickName;
        @Bind(R.id.tvTime)
        TextView tvTime;
        @Bind(R.id.tvTitle)
        TextView tvTitle;
        @Bind(R.id.tvContent)
        BookContentTextView tvContent;
        @Bind(R.id.tvBestComments)
        TextView tvBestComments;
        @Bind(R.id.rvBestComments)
        RecyclerView rvBestComments;
        @Bind(R.id.tvCommentCount)
        TextView tvCommentCount;

        public HeaderViewHolder(View view) {
            ButterKnife.bind(this, view);   //view绑定
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_community_book_discussion_detail;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerCommunityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("书荒互助区详情");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        id = getIntent().getStringExtra(INTENT_ID);

        mPresenter.attachView(this);
        mPresenter.getBookHelpDetail(id);
        mPresenter.getBestComments(id);
        mPresenter.getBookHelpComments(id, start, limit);
    }

    @Override
    public void configViews() {
        initAdapter(CommentListAdapter.class, false, true);

        mAdapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View headerView = LayoutInflater.from(BookHelpDetailActivity.this).inflate(R.layout.header_view_book_discussion_detail, parent, false);
                return headerView;
            }

            @Override
            public void onBindView(View headerView) {
                headerViewHolder = new HeaderViewHolder(headerView);
            }
        });

    }

    @Override
    public void showBookHelpDetail(BookHelp data) {
        Glide.with(mContext).load(Constant.IMG_BASE_URL + data.help.author.avatar)
                .placeholder(R.drawable.avatar_default)
                .transform(new GlideCircleTransform(mContext))
                .into(headerViewHolder.ivAvatar);

        headerViewHolder.tvNickName.setText(data.help.author.nickname);
        headerViewHolder.tvTime.setText(FormatUtils.getDescriptionTimeFromDateString(data.help.created));
        headerViewHolder.tvTitle.setText(data.help.title);
        headerViewHolder.tvContent.setText(data.help.content);
        headerViewHolder.tvCommentCount.setText(String.format(mContext.getString(R.string.comment_comment_count), data.help.commentCount));
    }

    @Override
    public void showBestComments(CommentList list) {
        if (list.comments.isEmpty()) {
            gone(headerViewHolder.tvBestComments, headerViewHolder.rvBestComments);
        } else {
            mBestCommentList.addAll(list.comments);
            headerViewHolder.rvBestComments.setHasFixedSize(true);
            headerViewHolder.rvBestComments.setLayoutManager(new LinearLayoutManager(this));
            headerViewHolder.rvBestComments.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));
            mBestCommentListAdapter = new BestCommentListAdapter(mContext, mBestCommentList);
            mBestCommentListAdapter.setOnItemClickListener(this);
            headerViewHolder.rvBestComments.setAdapter(mBestCommentListAdapter);
            visible(headerViewHolder.tvBestComments, headerViewHolder.rvBestComments);
        }
    }

    @Override
    public void showBookHelpComments(CommentList list) {
        mAdapter.addAll(list.comments);
        start = start + list.comments.size();
    }

    @Override
    public void onLoadMore() {
        super.onLoadMore();
        mPresenter.getBookHelpComments(id, start, limit);
    }

    @Override
    public void onItemClick(View view, int position, CommentList.CommentsBean data) {

    }

    @Override
    public void onItemClick(int position) {
        CommentList.CommentsBean data = (CommentList.CommentsBean) mAdapter.getItem(position);
    }

}
