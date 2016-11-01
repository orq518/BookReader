package com.ou.reader.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ou.reader.R;
import com.ou.reader.bean.CategoryList;

import java.util.ArrayList;
import java.util.List;

/**
 * The author ou on 2016/3/15.
 * todo
 */
public class BookStoreAdapter extends BaseAdapter {
    private List<CategoryList.MaleBean> mDataList = new ArrayList<>();
    private List<CategoryList.MaleBean> mDataList_old = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext;

    public BookStoreAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<CategoryList.MaleBean> data) {
        mDataList.clear();
        mDataList.addAll(data);
        notifyDataSetChanged();
    }
    public void setLastData(ArrayList<CategoryList.MaleBean> data) {
        mDataList_old.clear();
        mDataList_old.addAll(data);
    }
    public List<CategoryList.MaleBean> getData() {
        return mDataList;
    }

    public int getCount() {
        return mDataList.size();
    }

    public Object getItem(int position) {
        return mDataList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_top_category_list, null);
            holder = new ItemHolder();
            holder.tvName = (TextView) convertView
                    .findViewById(R.id.tvName);
            holder.tvBookCount = (TextView) convertView
                    .findViewById(R.id.tvBookCount);
            holder.tvBookCount_add = (TextView) convertView
                    .findViewById(R.id.tvBookCount_add);
            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }
        CategoryList.MaleBean bean = mDataList.get(position);
        holder.tvName.setText(bean.name);
        holder.tvBookCount.setText(String.format(mContext.getString(R.string
                .category_book_count), bean.bookCount));
        if(mDataList_old!=null&&mDataList_old.size()>position) {
            CategoryList.MaleBean bean_last = mDataList_old.get(position);
            if (bean_last != null && bean_last.bookCount > bean.bookCount) {
                holder.tvBookCount_add.setVisibility(View.VISIBLE);
                holder.tvBookCount_add.setText(String.format(mContext.getString(R.string
                        .category_book_count_add), (bean_last.bookCount + bean.bookCount)));
            } else {
                holder.tvBookCount_add.setVisibility(View.GONE);
            }
        }else{
            holder.tvBookCount_add.setVisibility(View.GONE);
        }
        return convertView;
    }


    class ItemHolder {
        TextView tvName;
        TextView tvBookCount;
        TextView tvBookCount_add;
    }
}