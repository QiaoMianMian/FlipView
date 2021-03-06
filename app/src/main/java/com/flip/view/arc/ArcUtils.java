package com.flip.view.arc;

import android.view.View;

public class ArcUtils {

    private ArcUtils() {
    }

    static int computeMeasureSize(int measureSpec, int defSize) {
        final int mode = View.MeasureSpec.getMode(measureSpec);
        switch (mode) {
            case View.MeasureSpec.EXACTLY:
                return View.MeasureSpec.getSize(measureSpec);
            case View.MeasureSpec.AT_MOST:
                return Math.min(defSize, View.MeasureSpec.getSize(measureSpec));
            default:
                return defSize;
        }
    }

    static float computeCircleX(float r, float degrees) {
        return (float) (r * Math.cos(Math.toRadians(degrees)));
    }

    static float computeCircleY(float r, float degrees) {
        return (float) (r * Math.sin(Math.toRadians(degrees)));
    }

    static int computeWidth(int origin, int size, int x) {
        switch (origin & ArcOrigin.HORIZONTAL_MASK) {
            case ArcOrigin.LEFT:
                //To the right edge
                return size - x;
            case ArcOrigin.RIGHT:
                //To the left edge
                return x;
            default:
                //To the shorter * 2 than the right edge and left edge
                return Math.min(x, size - x) * 2;
        }
    }

    static int computeHeight(int origin, int size, int y) {
        switch (origin & ArcOrigin.VERTICAL_MASK) {
            case ArcOrigin.TOP:
                //To the bottom edge
                return size - y;
            case ArcOrigin.BOTTOM:
                //To the top edge
                return y;
            default:
                //To the shorter * 2 than the top edge and bottom edge
                return Math.min(y, size - y) * 2;
        }
    }

}
