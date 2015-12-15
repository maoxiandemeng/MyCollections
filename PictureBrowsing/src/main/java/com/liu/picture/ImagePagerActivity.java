package com.liu.picture;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liu on 2015/12/9.
 */
public class ImagePagerActivity extends AppCompatActivity{
    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";

    @Bind(R.id.viewpage)
    ViewPager viewPager;
    @Bind(R.id.indicator)
    TextView indicator;

    private int pagerPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail_pager);
        ButterKnife.bind(this);

        pagerPosition = getIntent().getIntExtra(EXTRA_IMAGE_INDEX, 0);
        ArrayList<String> list = getIntent().getStringArrayListExtra(EXTRA_IMAGE_URLS);

        ImagePagerAdapter mAdapter = new ImagePagerAdapter(
                getSupportFragmentManager(), list);
        viewPager.setAdapter(mAdapter);

        CharSequence text = getString(R.string.viewpager_indicator, 1, viewPager
                .getAdapter().getCount());
        indicator.setText(text);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CharSequence text = getString(R.string.viewpager_indicator,
                        position + 1, viewPager.getAdapter().getCount());
                indicator.setText(text);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if (savedInstanceState != null) {
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }

        viewPager.setCurrentItem(pagerPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_POSITION, viewPager.getCurrentItem());
    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter {

        public ArrayList<String> fileList;

        public ImagePagerAdapter(FragmentManager fm, ArrayList<String> fileList) {
            super(fm);
            this.fileList = fileList;
        }

        @Override
        public int getCount() {
            return fileList == null ? 0 : fileList.size();
        }

        @Override
        public Fragment getItem(int position) {
            String url = fileList.get(position);
            return ImageDetailFragment.newInstance(url);
        }

    }
}
