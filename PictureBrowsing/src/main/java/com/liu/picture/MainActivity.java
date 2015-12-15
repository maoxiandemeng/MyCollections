package com.liu.picture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView1)
    RecyclerView recyclerView1;
    @Bind(R.id.recyclerView2)
    RecyclerView recyclerView2;

    private ArrayList<String>list1;
    private ArrayList<String>list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setDataList();

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayout.HORIZONTAL);

        MyAdapter adapter1 = new MyAdapter(this, list1);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(adapter1);

        MyAdapter adapter2 = new MyAdapter(this, list2);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);
    }

    private void setDataList(){
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        list1.add("http://img0.bdstatic.com/img/image/shouye/leimu/mingxing.jpg");

        list2.add("http://img0.bdstatic.com/img/image/shouye/leimu/mingxing.jpg");
        list2.add("http://img0.bdstatic.com/img/image/shouye/leimu/mingxing2.jpg");
        list2.add("http://img0.bdstatic.com/img/image/shouye/leimu/mingxing1.jpg");
        list2.add("http://img0.bdstatic.com/img/image/shouye/leimu/mingxing6.jpg");
        list2.add("http://d.hiphotos.baidu.com/album/w%3D2048/sign=14b0934b78310a55c424d9f4837d42a9/a8014c086e061d95e9fd3e807af40ad163d9cacb.jpg");
        list2.add("http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=ccd33b46d53f8794d7ff4b26e2207fc9/0d338744ebf81a4c0f993437d62a6059242da6a1.jpg");
        list2.add("http://c.hiphotos.bdimg.com/album/s%3D900%3Bq%3D90/sign=b8658f17f3d3572c62e290dcba28121a/5fdf8db1cb134954bb97309a574e9258d0094a47.jpg");
        list2.add("http://f.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=6b62f61bac6eddc422e7b7f309e0c7c0/6159252dd42a2834510deef55ab5c9ea14cebfa1.jpg");
        list2.add("http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=e58fb67bc8ea15ce45eee301863b4bce/a5c27d1ed21b0ef4fd6140a0dcc451da80cb3e47.jpg");
        list2.add("http://c.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=cdab1512d000baa1be2c44b3772bc82f/91529822720e0cf3855c96050b46f21fbf09aaa1.jpg");
    }
}
