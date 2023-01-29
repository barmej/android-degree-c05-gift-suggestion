package com.barmej.giftsuggestion;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
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
     * Two dimens array that hold resources ids of gift pictures and names
     */
    private int[][] mGifts = {
            {R.drawable.gift_1, R.string.damask_rose},
            {R.drawable.gift_2, R.string.flower},
            {R.drawable.gift_3, R.string.cake},
            {R.drawable.gift_4, R.string.laptop},
            {R.drawable.gift_5, R.string.mobile},
            {R.drawable.gift_6, R.string.book},
            {R.drawable.gift_7, R.string.piece_of_cake},
            {R.drawable.gift_8, R.string.shirt},
            {R.drawable.gift_9, R.string.shoe},
            {R.drawable.gift_10, R.string.diamond}};

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
        Drawable giftDrawable = ContextCompat.getDrawable(this, mGifts[mCurrentIndex][0]);
        mGiftImageView.setImageDrawable(giftDrawable);
        mGiftNameTextView.setText(mGifts[mCurrentIndex][1]);
    }

}
