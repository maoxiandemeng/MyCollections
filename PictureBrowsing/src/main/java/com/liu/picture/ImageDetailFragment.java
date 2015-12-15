package com.liu.picture;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.liu.picture.photoview.PhotoViewAttacher;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageDetailFragment extends Fragment {
    @Bind(R.id.image)
    ImageView mImageView;
    private PhotoViewAttacher mAttacher;

    private String mImageUrl;

    public static ImageDetailFragment newInstance(String imageUrl) {
        final ImageDetailFragment f = new ImageDetailFragment();

        final Bundle args = new Bundle();
        args.putString("url", imageUrl);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrl = getArguments() != null ? getArguments().getString("url") : null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_detail_fragment, container, false);
        ButterKnife.bind(this, view);
//        mAttacher = new PhotoViewAttacher(mImageView);
//        mAttacher.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
//
//            @Override
//            public void onPhotoTap(View arg0, float arg1, float arg2) {
//                getActivity().finish();
//            }
//        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(getActivity()).load(mImageUrl).placeholder(R.mipmap.loading).error(R.mipmap.ic_launcher).into(mImageView);
//        mAttacher.update();
    }
}
