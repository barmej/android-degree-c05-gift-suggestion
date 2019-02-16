package com.barmej.giftsuggestion;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * Constant for Log messages
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Constant used as bundle key
     */
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";

    /**
     * Instance of Random class used to generate random index
     */
    private Random mRandom;

    /**
     * ImageView to display gift pictures
     */
    private ImageView mGiftImageView;

    /**
     * TextView to display gift names
     */
    private TextView mGiftNameTextView;

    /**
     * Array that hold gift objects
     */
    private Gift[] mGifts = new Gift[10];

    /**
     * Variable used as index to move through images array
     */
    private int mCurrentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create new Random object
        mRandom = new Random();
        // Get ImageView from view hierarchy
        mGiftImageView = findViewById(R.id.image_gift_picture);
        // Get TextView from view hierarchy
        mGiftNameTextView = findViewById(R.id.text_gift_name);

        Gift gift1 = new Gift();
        gift1.setName(R.string.damask_rose);
        gift1.setPicture(R.drawable.gift_1);
        mGifts[0] = gift1;

        Gift gift2 = new Gift();
        gift2.setName(R.string.flower);
        gift2.setPicture(R.drawable.gift_2);
        mGifts[1] = gift2;

        Gift gift3 = new Gift();
        gift3.setName(R.string.cake);
        gift3.setPicture(R.drawable.gift_3);
        mGifts[2] = gift3;

        Gift gift4 = new Gift();
        gift4.setName(R.string.laptop);
        gift4.setPicture(R.drawable.gift_4);
        mGifts[3] = gift4;

        Gift gift5 = new Gift();
        gift5.setName(R.string.mobile);
        gift5.setPicture(R.drawable.gift_5);
        mGifts[4] = gift5;

        Gift gift6 = new Gift();
        gift6.setName(R.string.book);
        gift6.setPicture(R.drawable.gift_6);
        mGifts[5] = gift6;

        Gift gift7 = new Gift();
        gift7.setName(R.string.piece_of_cake);
        gift7.setPicture(R.drawable.gift_7);
        mGifts[6] = gift7;

        Gift gift8 = new Gift();
        gift8.setName(R.string.shirt);
        gift8.setPicture(R.drawable.gift_8);
        mGifts[7] = gift8;

        Gift gift9 = new Gift();
        gift9.setName(R.string.shoe);
        gift9.setPicture(R.drawable.gift_9);
        mGifts[8] = gift9;

        Gift gift10 = new Gift();
        gift10.setName(R.string.diamond);
        gift10.setPicture(R.drawable.gift_10);
        mGifts[9] = gift10;

        Log.i(TAG, "Created");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Restarted");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroyed");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_CURRENT_INDEX)) {
            mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);
            if (mCurrentIndex != -1) {
                showSuggestedGift();
            }
        }
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX, mCurrentIndex);
        Log.i(TAG, "onSaveInstanceState");
    }


    /**
     * Called by android system when the button clicked
     * It's specified as click handler using XML onClick attribute
     *
     * @param view the view that's being clicked
     */
    public void display(View view) {
        // If counter does not exceed the last index in the array
        if (mCurrentIndex < 9) {
            // Generate random index
            mCurrentIndex = mRandom.nextInt(10);
            showSuggestedGift();
        } else {
            // Reset the counter
            mCurrentIndex = -1;
        }
    }

    /**
     * Show the picture & name of the gift located at current index
     */
    private void showSuggestedGift() {
        Gift suggestedGift = mGifts[mCurrentIndex];
        Drawable giftDrawable = ContextCompat.getDrawable(this, suggestedGift.getPicture());
        mGiftImageView.setImageDrawable(giftDrawable);
        mGiftNameTextView.setText(suggestedGift.getName());
    }

}
