package com.flip.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flip.view.bean.ColorPal;
import com.flip.view.bean.Event;

import java.util.ArrayList;


public class FlipAdapter extends RecyclerView.Adapter<FlipAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Event> events = new ArrayList<>();

    private int mLastPosition = -1;

    private OnItemListener mItemListener;

    public interface OnItemListener {
        void onItemClick(ViewHolder holder, Event event);
    }

    public FlipAdapter(Context context) {
        this.mContext = context;
        initData();
    }

    private void initData() {
        events.add(new Event(Event.TAG_TEL, mContext.getString(R.string.flip_event_tel), R.mipmap.ev_tel_0, R.mipmap.ev_tel_1));
        events.add(new Event(Event.TAG_SMS, mContext.getString(R.string.flip_event_sms), R.mipmap.ev_sms_0, R.mipmap.ev_sms_1));
        events.add(new Event(Event.TAG_EMAIL, mContext.getString(R.string.flip_event_email), R.mipmap.ev_email_0, R.mipmap.ev_email_1));
        events.add(new Event(Event.TAG_FACEBOOK, mContext.getString(R.string.flip_event_facebook), R.mipmap.ev_facebook_0, R.mipmap.ev_facebook_1));
        events.add(new Event(Event.TAG_WE_CHAT, mContext.getString(R.string.flip_event_wechat), R.mipmap.ev_wechat_0, R.mipmap.ev_wechat_1));
        events.add(new Event(Event.TAG_WEI_BO, mContext.getString(R.string.flip_event_sina), R.mipmap.ev_sina_0, R.mipmap.ev_sina_1));
        events.add(new Event(Event.TAG_TWITTER, mContext.getString(R.string.flip_event_twitter), R.mipmap.ev_twitter_0, R.mipmap.ev_twitter_1));
        events.add(new Event(Event.TAG_QQ, mContext.getString(R.string.flip_event_qq), R.mipmap.ev_qq_0, R.mipmap.ev_qq_1));
    }

    @Override
    public FlipAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.flip_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        initSelected(holder, events.get(position));
    }

    private void initSelected(ViewHolder holder, Event event) {
        if (event == null || holder == null) return;
        String tag = event.tag;
        int color = (int) SPUtils.getParam(mContext, tag, 0);
        holder.mFlipView.flip(false); //正面
        //默认
        holder.mColorIv1.setImageResource(R.mipmap.ic_color_1_0);
        holder.mColorIv2.setImageResource(R.mipmap.ic_color_2_0);
        holder.mColorIv3.setImageResource(R.mipmap.ic_color_3_0);
        holder.mColorIv4.setImageResource(R.mipmap.ic_color_4_0);
        holder.mColorIv5.setImageResource(R.mipmap.ic_color_5_0);
        holder.mColorIv6.setImageResource(R.mipmap.ic_color_6_0);
        switch (color) {
            case 1:
                holder.mColorIv1.setImageResource(R.mipmap.ic_color_1_1);
                break;
            case 2:
                holder.mColorIv2.setImageResource(R.mipmap.ic_color_2_1);
                break;
            case 3:
                holder.mColorIv3.setImageResource(R.mipmap.ic_color_3_1);
                break;
            case 4:
                holder.mColorIv4.setImageResource(R.mipmap.ic_color_4_1);
                break;
            case 5:
                holder.mColorIv5.setImageResource(R.mipmap.ic_color_5_1);
                break;
            case 6:
                holder.mColorIv6.setImageResource(R.mipmap.ic_color_6_1);
                break;
            case 0:
            case 7:
                break;
        }
        setFrontColor(holder.mFlipFrontRlt, color);
        setFrontView(holder.mFrontIv, holder.mFrontTv, event);
    }

    //设置前布局视图
    private void setFrontView(ImageView iv, TextView tv, Event event) {
        if (iv == null || tv == null || event == null) return;
        String tag = event.tag;
        int resId = event.resId;
        int resId2 = event.resId2;
        String name = event.name;
        tv.setText(name);
        int color = (int) SPUtils.getParam(mContext, tag, 0);
        if (color == 7 || color == 0) {
            iv.setImageResource(resId);
            tv.setTextColor(Color.parseColor("#999999"));
        } else {
            iv.setImageResource(resId2);
            tv.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    //设置前布局的背景色
    private void setFrontColor(RelativeLayout layout, int color) {
        ColorPal pal = ColorPal.getColor(color);
        String value = pal.color;
        int res;
        if (TextUtils.equals(value, ColorPal.Color_1.color)) {
            res = R.drawable.flip_front_color_1;
        } else if (TextUtils.equals(value, ColorPal.Color_2.color)) {
            res = R.drawable.flip_front_color_2;
        } else if (TextUtils.equals(value, ColorPal.Color_3.color)) {
            res = R.drawable.flip_front_color_3;
        } else if (TextUtils.equals(value, ColorPal.Color_4.color)) {
            res = R.drawable.flip_front_color_4;
        } else if (TextUtils.equals(value, ColorPal.Color_5.color)) {
            res = R.drawable.flip_front_color_5;
        } else if (TextUtils.equals(value, ColorPal.Color_6.color)) {
            res = R.drawable.flip_front_color_6;
        } else {
            res = R.drawable.flip_front_color_7;
        }
        layout.setBackgroundResource(res);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        FlipView mFlipView;

        RelativeLayout mFlipFrontRlt;
        ImageView mFrontIv;
        TextView mFrontTv;

        RelativeLayout mFlipRearRlt;
        ImageView mColorIv1;
        ImageView mColorIv2;
        ImageView mColorIv3;
        ImageView mColorIv4;
        ImageView mColorIv5;
        ImageView mColorIv6;
        ImageView mColorIv7;

        public ViewHolder(View v) {
            super(v);
            //翻转布局
            mFlipView = (FlipView) v.findViewById(R.id.flip_view);
            //前布局
            mFlipFrontRlt = (RelativeLayout) mFlipView.getFrontLayout();
            mFlipFrontRlt.setOnClickListener(this);
            mFrontIv = (ImageView) mFlipFrontRlt.findViewById(R.id.front_iv);
            mFrontTv = (TextView) mFlipFrontRlt.findViewById(R.id.front_tv);
            //后布局
            mFlipRearRlt = (RelativeLayout) mFlipView.getRearLayout();
            mColorIv1 = (ImageView) mFlipRearRlt.findViewById(R.id.rear_color_1);
            mColorIv1.setOnClickListener(this);
            mColorIv2 = (ImageView) mFlipRearRlt.findViewById(R.id.rear_color_2);
            mColorIv2.setOnClickListener(this);
            mColorIv3 = (ImageView) mFlipRearRlt.findViewById(R.id.rear_color_3);
            mColorIv3.setOnClickListener(this);
            mColorIv4 = (ImageView) mFlipRearRlt.findViewById(R.id.rear_color_4);
            mColorIv4.setOnClickListener(this);
            mColorIv5 = (ImageView) mFlipRearRlt.findViewById(R.id.rear_color_5);
            mColorIv5.setOnClickListener(this);
            mColorIv6 = (ImageView) mFlipRearRlt.findViewById(R.id.rear_color_6);
            mColorIv6.setOnClickListener(this);
            mColorIv7 = (ImageView) mFlipRearRlt.findViewById(R.id.rear_color_7);
            mColorIv7.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mLastPosition != -1 && mLastPosition != getLayoutPosition()) {
                notifyItemChanged(mLastPosition);
            }
            mLastPosition = getLayoutPosition();
            Event event = events.get(mLastPosition);
            switch (v.getId()) {
                case R.id.front_rlt:
//                    clickSelected(true, event, 0);
                    if (mItemListener != null) {
                        mItemListener.onItemClick(this, event);
                    }
                    break;
                case R.id.rear_color_1:
                    clickSelected(false, event, 1);
                    break;
                case R.id.rear_color_2:
                    clickSelected(false, event, 2);
                    break;
                case R.id.rear_color_3:
                    clickSelected(false, event, 3);
                    break;
                case R.id.rear_color_4:
                    clickSelected(false, event, 4);
                    break;
                case R.id.rear_color_5:
                    clickSelected(false, event, 5);
                    break;
                case R.id.rear_color_6:
                    clickSelected(false, event, 6);
                    break;
                case R.id.rear_color_7:
                    clickSelected(false, event, 7);
                    break;
            }
        }

        /**
         * @param flip(true 反面 false 正面)
         * @param event
         * @param color(颜色编号)
         */
        public void clickSelected(boolean flip, Event event, int color) {
            String tag = event.tag;
            if (color == 0) {
                color = (int) SPUtils.getParam(mContext, tag, 0);
            }
            mFlipView.flip(flip);
            SPUtils.setParam(mContext, tag, color);
            //默认
            mColorIv1.setImageResource(R.mipmap.ic_color_1_0);
            mColorIv2.setImageResource(R.mipmap.ic_color_2_0);
            mColorIv3.setImageResource(R.mipmap.ic_color_3_0);
            mColorIv4.setImageResource(R.mipmap.ic_color_4_0);
            mColorIv5.setImageResource(R.mipmap.ic_color_5_0);
            mColorIv6.setImageResource(R.mipmap.ic_color_6_0);
            switch (color) {
                case 1:
                    mColorIv1.setImageResource(R.mipmap.ic_color_1_1);
                    break;
                case 2:
                    mColorIv2.setImageResource(R.mipmap.ic_color_2_1);
                    break;
                case 3:
                    mColorIv3.setImageResource(R.mipmap.ic_color_3_1);
                    break;
                case 4:
                    mColorIv4.setImageResource(R.mipmap.ic_color_4_1);
                    break;
                case 5:
                    mColorIv5.setImageResource(R.mipmap.ic_color_5_1);
                    break;
                case 6:
                    mColorIv6.setImageResource(R.mipmap.ic_color_6_1);
                    break;
                case 7:
                    break;
            }
            setFrontColor(mFlipFrontRlt, color);
            setFrontView(mFrontIv, mFrontTv, event);
            if (!flip) setLightColor(tag, color);
        }
    }

    /**
     * @param tag(判断事件标记)
     * @param color(颜色编号)
     */
    private void setLightColor(String tag, int color) {
        //开关
        int state = 1;
        if (color == 7) state = 0;
        //事件
        int event = 0;
        switch (tag) {
            case Event.TAG_TEL:
                event = 1;
                break;
            case Event.TAG_SMS:
                event = 2;
                break;
            case Event.TAG_EMAIL:
                event = 3;
                break;
            case Event.TAG_FACEBOOK:
                event = 4;
                break;
            case Event.TAG_WE_CHAT:
                event = 5;
                break;
            case Event.TAG_WEI_BO:
                event = 6;
                break;
            case Event.TAG_TWITTER:
                event = 7;
                break;
            case Event.TAG_QQ:
                event = 9;
                break;
        }
        //颜色
        ColorPal pal = ColorPal.getColor(color);
        int value = Color.parseColor(pal.color);
        int red = Color.red(value);
        int green = Color.green(value);
        int blue = Color.blue(value);
    }


    public void setItemListener(OnItemListener mItemListener) {
        this.mItemListener = mItemListener;
    }

}