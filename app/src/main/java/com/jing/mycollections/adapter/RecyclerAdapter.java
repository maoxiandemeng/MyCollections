package com.jing.mycollections.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jing.mycollections.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 2015/12/2.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BaseViewHolder> {

    private Context mContext;
    private List<String> mDataSet;
    private int i=0;

    public RecyclerAdapter(Context context) {
        mContext = context;
        mDataSet = new ArrayList<>();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.recyclerview_item, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ChildViewHolder textViewHolder = (ChildViewHolder) holder;
        textViewHolder.bindView(mDataSet.get(position), position);
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    /**
     * 从position开始删除，删除
     *
     * @param position
     * @param itemCount
     *            删除的数目
     */
    protected void removeAll(int position, int itemCount) {
        for (int i = 0; i < itemCount; i++) {
            mDataSet.remove(position);
        }
        notifyItemRangeRemoved(position, itemCount);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void add(String text, int position) {
        mDataSet.add(position, text);
        notifyItemInserted(position);
    }

    public void addAll(List<String> list, int position) {
        mDataSet.addAll(position, list);
        notifyItemRangeInserted(position, list.size());
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class ChildViewHolder extends BaseViewHolder {

        public TextView text;
        public ImageView image;

        public ChildViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.image);
        }

        public void bindView(String str, int position) {
            text.setText(str);
        }

    }

}
