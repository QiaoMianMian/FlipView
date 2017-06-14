package com.flip.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import com.flip.view.bean.Event;

public class MainActivity extends AppCompatActivity {
    //颜色组件
    private RecyclerView mColorRv;
    private FlipAdapter mFlipAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //颜色组件
        mColorRv = (RecyclerView) findViewById(R.id.frg_status_grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mColorRv.setLayoutManager(gridLayoutManager);
        mFlipAdapter = new FlipAdapter(this);
        mFlipAdapter.setItemListener(new FlipAdapter.OnItemListener() {
            @Override
            public void onItemClick(FlipAdapter.ViewHolder holder, Event event) {
                holder.clickSelected(true, event, 0);
            }
        });
        mColorRv.setAdapter(mFlipAdapter);
        ((SimpleItemAnimator) mColorRv.getItemAnimator()).setSupportsChangeAnimations(false); //解决闪屏问题
    }
}
