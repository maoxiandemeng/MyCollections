package com.liu.picture;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

public class ViewPageActivity extends AppCompatActivity {
    private static final String ISLOCKED_ARG = "isLocked";
    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";

    @Bind(R.id.hackypage)
    HackyViewPager hackyViewPager;
    @Bind(R.id.indicator)
    TextView indicator;
    private int pagerPosition;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        ButterKnife.bind(this);

        pagerPosition = getIntent().getIntExtra(EXTRA_IMAGE_INDEX, 0);
        list = getIntent().getStringArrayListExtra(EXTRA_IMAGE_URLS);
        hackyViewPager.setAdapter(new SimplePageAdapter(list));
        CharSequence text = getString(R.string.viewpager_indicator, 1, hackyViewPager
                .getAdapter().getCount());
        indicator.setText(text);

        if (savedInstanceState != null) {
            boolean isLocked = savedInstanceState.getBoolean(ISLOCKED_ARG, false);
            hackyViewPager.setLocked(isLocked);
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }

        hackyViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CharSequence text = getString(R.string.viewpager_indicator,
                        position + 1, hackyViewPager.getAdapter().getCount());
                indicator.setText(text);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        hackyViewPager.setCurrentItem(pagerPosition);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (hackyViewPager != null) {
            outState.putBoolean(ISLOCKED_ARG, hackyViewPager.isLocked());
            outState.putInt(STATE_POSITION, hackyViewPager.getCurrentItem());
        }
        super.onSaveInstanceState(outState);
    }

    class SimplePageAdapter extends PagerAdapter{
        private ArrayList<String> list;

        public SimplePageAdapter(ArrayList<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            Glide.with(ViewPageActivity.this).load(list.get(position)).error(R.mipmap.ic_launcher).into(photoView);
            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
