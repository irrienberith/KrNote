package com.kyon.levelup.krnote.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by kyon on 15-4-13.
 */
public class KUIHelper {
    public static final String TAG = "KUIHelper";


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    /**
     * 获取一个居中的rect的坐标
     *
     * @param width  宽度
     * @param height 高度
     * @return 四个点坐标
     */
    public static int[] getRectLocation(Context context, int width, int height) {
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int centerX = getScreenWidth(context) >> 1;
        int centerY = (getScreenHeight(context) + rect.top) >> 1;

        return new int[]{centerX - (width >> 1), centerY - (height >> 1), centerX + (width >> 1), centerY + (height >> 1)};

    }

    /**
     * 获取屏幕尺寸
     *
     * @param context 上下文
     * @return 返回尺寸
     */
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }


    /**
     * 获取一个view的bitmap
     *
     * @param v 目标View
     * @return 返回位图
     */
    public static Bitmap getBitmapFromView(View v) {
        if (v == null) {
            return null;
        }
        Bitmap screenShot;
        screenShot = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(screenShot);
        mCanvas.translate(-v.getScrollX(), -v.getScrollY());
        v.draw(mCanvas);
        return screenShot;
    }


    public static int clamp(int x, int a, int b) {
        return (x < a) ? a : (x > b) ? b : x;
    }


    /**
     * 去除字符串前后双引号
     *
     * @param origin 原字符串
     * @return 结果字符串
     */
    public static String trimQuote(String origin) {
        String afterConvert = origin;
        if (origin.startsWith("\"") && origin.endsWith("\"")) {
            afterConvert = afterConvert.substring(1, afterConvert.length() - 1);
        }
        return afterConvert;
    }

    /**
     * 去除字符串开头的换行符
     *
     * @param origin 原字符串
     * @return
     */
    public static String trimNewLine(String origin) {
        if (KStringUtils.isBlank(origin) || !origin.startsWith("\n")) {
            return origin;
        }
        return origin.substring(1);
    }

    /**
     * 换行字符串
     *
     * @param target 目标字符串
     * @param part1  前半部分
     * @param part2  后半部分
     * @return 返回值
     */
    public static String makeWrapStr(String target, String part1, String part2) {
        target += "\n" + part1 + ":" + part2;
        return target;
    }
}
