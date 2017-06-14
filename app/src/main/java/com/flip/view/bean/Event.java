package com.flip.view.bean;

public class Event {
    public static final String TAG_TEL = "tel"; //来电
    public static final String TAG_SMS = "sms"; //短信
    public static final String TAG_EMAIL = "email"; //邮件
    public static final String TAG_FACEBOOK = "facebook"; //Facebook
    public static final String TAG_WE_CHAT = "we.chat"; //微信
    public static final String TAG_WEI_BO = "wei.bo"; //微博
    public static final String TAG_TWITTER = "twitter"; //Twitter
    public static final String TAG_QQ = "qq"; //QQ


    public String tag;
    public String name;
    public int resId;
    public int resId2;

    public Event(String tag, String name, int resId, int resId2) {
        this.tag = tag;
        this.name = name;
        this.resId = resId;
        this.resId2 = resId2;
    }

    @Override
    public String toString() {
        return "Event{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", resId=" + resId +
                ", resId2=" + resId2 +
                '}';
    }
}
