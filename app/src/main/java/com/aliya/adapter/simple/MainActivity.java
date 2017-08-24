package com.aliya.adapter.simple;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aliya.adapter.DecorAdapter;
import com.aliya.adapter.OnItemClickListener;
import com.aliya.adapter.OnItemLongClickListener;
import com.aliya.adapter.divider.GridDivider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycle;
    private DecorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UIUtils.sContext = this.getApplicationContext();

        recycle = (RecyclerView) findViewById(R.id.recycler);

        recycle.setLayoutManager(new GridLayoutManager(this, 3));

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }

        mAdapter = new DecorAdapter(new DemoAdapter(list));

        recycle.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Log.e("TAG", "onItemClick " + position);
            }
        });
        mAdapter.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View itemView, int position) {
                Log.e("TAG", "onItemLongClick " + position);
                return true;
            }
        });

//        recycle.addItemDecoration(new ListDivider(5, Color.BLUE,0,0, true, false, false));
        recycle.addItemDecoration(new GridDivider(5, Color.BLUE, false, false));

        View inflate = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) inflate.findViewById(R.id.tv)).setText("第1个header");
        mAdapter.addHeaderView(inflate);

        View inflate1 = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) inflate1.findViewById(R.id.tv)).setText("第2个header");
        mAdapter.addHeaderView(inflate1);

        View inflate2 = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) inflate2.findViewById(R.id.tv)).setText("第3个header");
        mAdapter.addHeaderView(inflate2);

        View footer = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) footer.findViewById(R.id.tv)).setText("我是加载更多");
        mAdapter.setFooterLoadMore(footer);

        View footer0 = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) footer0.findViewById(R.id.tv)).setText("我是覆盖加载更多");
        mAdapter.setFooterLoadMore(footer0);

        View footer1 = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) footer1.findViewById(R.id.tv)).setText("第1个footer");
        mAdapter.addFooterView(footer1);

        View footer2 = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) footer2.findViewById(R.id.tv)).setText("第2个footer");
        mAdapter.addFooterView(footer2);

        View refresh = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) refresh.findViewById(R.id.tv)).setText("我是下拉刷新");
        mAdapter.setHeaderRefresh(refresh);

        View refresh1 = getLayoutInflater().inflate(R.layout.item_header_layout, recycle, false);
        ((TextView) refresh1.findViewById(R.id.tv)).setText("我要覆盖下拉刷新");
        mAdapter.setHeaderRefresh(refresh1);

    }
}
