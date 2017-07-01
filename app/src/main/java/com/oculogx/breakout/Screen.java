package com.oculogx.breakout;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by ss on 6/28/17.
 */

public class Screen {
    // Static Final Variables
    private static final int cWidth = 40; // cubby width in px
    private static final int cHeight = 15; // cubby height in px
    private static final int col = cWidth * 6; // number of columns
    private static final int row = cHeight * 2; // number of rows
    private static final int h = cHeight * 6; // number of stacked cubbies

    // Instance variables
    private Bitmap screen;
    private int bgColor;


    public Screen() {
        this(640, 360, Color.BLACK);
    }

    public Screen(int width, int height, int bgColor) {
        screen = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.bgColor = bgColor;
        screen.eraseColor(bgColor);
    }



}
