package com.oculogx.layout;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.glass.widget.CardBuilder;

public class Cards extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);
    }

    private View buildView() {
        CardBuilder card = new CardBuilder(this, CardBuilder.Layout.TEXT);

        Bitmap b = Bitmap.createBitmap(400, 360, Bitmap.Config.ARGB_8888);
        b.eraseColor(Color.BLACK);

        return card.getView();
    }
}
