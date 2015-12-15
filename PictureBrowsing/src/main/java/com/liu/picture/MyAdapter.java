package com.liu.picture;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liu on 2015/12/9.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private ArrayList<String> imgUrls;
    private Context context;

    public MyAdapter(Context context, ArrayList<String> imgUrls) {
        this.context = context;
        this.imgUrls = imgUrls;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        String s = imgUrls.get(position);
        Glide.with(context).load(s).placeholder(R.mipmap.loading).error(R.mipmap.ic_launcher).into(holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewPageActivity.class);
                intent.putExtra(ViewPageActivity.EXTRA_IMAGE_INDEX, position);
                intent.putStringArrayListExtra(ViewPageActivity.EXTRA_IMAGE_URLS, imgUrls);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgUrls.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.album_image)
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
