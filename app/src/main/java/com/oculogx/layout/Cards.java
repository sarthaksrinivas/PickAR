package com.oculogx.layout;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardBuilder;

public class Cards extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
    }

    public Bitmap generateLayout(){
        Bitmap b = Bitmap.createBitmap(640, 360, Bitmap.Config.ARGB_8888);
        b.eraseColor(Color.BLACK);

        // grid width and height, can generalize
        int gridWidth = 20;
        int gridHeight = 20;

        // calculation of full rack display
        for(int i = 0; i < b.getWidth(); i++){
            for(int j = 0; j < b.getHeight(); j++){

                // create grids for racking
                if( j % gridHeight == 0 || i % gridWidth == 0){
                    b.setPixel(i, j, Color.WHITE);
                }
            }
        }

        return b;
    }

}
