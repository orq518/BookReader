package com.ou.reader.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ou.reader.R;
import com.ou.reader.base.Constant;
import com.ou.reader.bean.Recommend;
import com.yuyh.easyadapter.glide.GlideRoundTransform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.ou.reader.R.color.dark_orchid;
import static com.ou.reader.R.color.dodger_blue;
import static com.ou.reader.R.color.mantis;
import static com.ou.reader.R.color.portland_orange;
import static com.ou.reader.R.color.usc_gold;

public class SportCardsAdapter extends RecyclerView.Adapter<SportCardsAdapter.SportCardViewHolder> {
    private final List<Recommend.RecommendBooks> items = new ArrayList<>();
    private Context context;
    private OnItemClickListener itemClickListener;
    int[] bgColor=new int[]{dark_orchid,mantis,usc_gold,dodger_blue,portland_orange};
    public SportCardsAdapter(Context context) {
        this.context = context;
    }

    public void setData(Collection<Recommend.RecommendBooks> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }


    @Override
    public SportCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new SportCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SportCardViewHolder holder, int position) {
        Recommend.RecommendBooks item = items.get(position);
        holder.tvSportTitle.setText(item.title);
        holder.tvSportSubtitle.setText(item.shortIntro);
//        holder.ivSportPreview.setImageResource(item.getImageResId());
        Glide.with(context).load(Constant.IMG_BASE_URL + item.cover).placeholder(R.drawable.cover_default).transform(new GlideRoundTransform(context)).into(holder.ivSportPreview);
        holder.tvTime.setText("作者："+item.author);
        holder.tvDayPart.setText(item.lastChapter);

        ((CardView) holder.itemView).setCardBackgroundColor(ContextCompat.getColor(context,bgColor[position%bgColor.length]));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.ivSportPreview.setTransitionName("shared" + String.valueOf(position));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClicked(holder.getAdapterPosition(), holder.ivSportPreview);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public OnItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    Recommend.RecommendBooks getModelByPos(int pos) {
        return items.get(pos);

    }

    public interface OnItemClickListener {
        void onItemClicked(int pos, View view);
    }

    class SportCardViewHolder extends RecyclerView.ViewHolder {

        final TextView tvSportTitle;
        final TextView tvSportSubtitle;
        final TextView tvTime;
        final TextView tvDayPart;
        ImageView ivSportPreview;

        SportCardViewHolder(View itemView) {
            super(itemView);
            tvSportTitle = (TextView) itemView.findViewById(R.id.tvSportTitle);
            tvSportSubtitle = (TextView) itemView.findViewById(R.id.tvSportSubtitle);
            ivSportPreview = (ImageView) itemView.findViewById(R.id.ivSportPreview);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvDayPart = (TextView) itemView.findViewById(R.id.tvDayPart);
        }
    }
}
