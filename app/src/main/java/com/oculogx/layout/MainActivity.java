package com.oculogx.layout;

import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardBuilder;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private View mView;
    private ArrayList<CardBuilder> mCards;
    private CardScrollView mCardScrollView;
    private ScreenAdapter mAdapter;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // keep screen on

        buildView();

        mCardScrollView = new CardScrollView(this);
        mAdapter = new ScreenAdapter();
        mCardScrollView.setAdapter(mAdapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void buildView() {
        Resources res = getResources();
        String[] screens = res.getStringArray(R.array.screens);
        mCards = new ArrayList<CardBuilder>();
        for (String name : screens) {
            mCards.add(new CardBuilder(this, CardBuilder.Layout.TEXT).addImage(
                    res.getIdentifier(name, "drawable", getPackageName())
            ));
        }

//        CardBuilder card = new CardBuilder(this, CardBuilder.Layout.TEXT);

//        card.addImage(R.drawable.screen1);
    }

    private class ScreenAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return CardBuilder.getViewTypeCount();
        }

        @Override
        public int getItemViewType(int position){
            return mCards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return mCards.get(position).getView(convertView, parent);
        }
    }

}