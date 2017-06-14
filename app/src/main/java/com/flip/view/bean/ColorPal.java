package com.flip.view.bean;

import android.graphics.Color;

public enum ColorPal {

    Color_1("#808000"),   //#D659E4

    Color_2("#008000"),   //#6763D8

    Color_3("#008080"),   //#4AC4E8

    Color_4("#000080"),   //#43E59F

    Color_5("#800080"),   //#EEC735

    Color_6("#800000"),  //#E35862

    Color_7("#FFFFFF");  //#FFFFFF

    public final String color;

    ColorPal(String color) {
        this.color = color;
    }

    /**
     * @param color (颜色编号)
     */
    public static ColorPal getColor(int color) {
        switch (color) {
            case 1:
                return ColorPal.Color_1;
            case 2:
                return ColorPal.Color_2;
            case 3:
                return ColorPal.Color_3;
            case 4:
                return ColorPal.Color_4;
            case 5:
                return ColorPal.Color_5;
            case 6:
                return ColorPal.Color_6;
            case 0:
            case 7:
            default:
                return ColorPal.Color_7;
        }
    }

    //颜色编号
    public static int getColorCode(int red, int green, int blue) {
//        LogUtils.i("getColorCode--> red:" + red + ",green:" + green + ",blue:" + blue);
        int color = Color.rgb(red, green, blue);
        int code = 0;
        if (color == Color.parseColor(Color_1.color)) {
            code = 1;
        } else if (color == Color.parseColor(Color_2.color)) {
            code = 2;
        } else if (color == Color.parseColor(Color_3.color)) {
            code = 3;
        } else if (color == Color.parseColor(Color_4.color)) {
            code = 4;
        } else if (color == Color.parseColor(Color_5.color)) {
            code = 5;
        } else if (color == Color.parseColor(Color_6.color)) {
            code = 6;
        } else if (color == Color.parseColor(Color_7.color)) {
            code = 7;
        }
        return code;
    }
}
