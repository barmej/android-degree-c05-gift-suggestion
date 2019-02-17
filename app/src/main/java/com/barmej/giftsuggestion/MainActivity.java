package com.barmej.giftsuggestion;

import android.graphics.Color;
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
    private Gift[] mGifts = {
            new Gift(R.string.damask_rose, R.drawable.gift_1),
            new Gift(R.string.flower, R.drawable.gift_2),
            new Gift(R.string.cake, R.drawable.gift_3),
            new Gift(R.string.laptop, R.drawable.gift_4),
            new Gift(R.string.mobile, R.drawable.gift_5),
            new Gift(R.string.book, R.drawable.gift_6),
            new Gift(R.string.piece_of_cake, R.drawable.gift_7),
            new Gift(R.string.shirt, R.drawable.gift_8),
            new Gift(R.string.shoe, R.drawable.gift_9),
            new Gift(R.string.diamond, R.drawable.gift_10),
    };

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
            changeGiftNameTextColor();
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

    /**
     * Change gift name color based on selected gift!
     */
    private void changeGiftNameTextColor() {
        int giftName = mGifts[mCurrentIndex].getName();
        if(giftName == R.string.damask_rose || giftName == R.string.flower) {
            mGiftNameTextView.setTextColor(Color.BLUE);
        } else if(giftName == R.string.cake || giftName == R.string.piece_of_cake) {
            mGiftNameTextView.setTextColor(Color.BLUE);
        } else if(giftName == R.string.laptop || giftName == R.string.mobile) {
            mGiftNameTextView.setTextColor(Color.MAGENTA);
        }  else if(giftName == R.string.book) {
            mGiftNameTextView.setTextColor(Color.CYAN);
        } else if(giftName == R.string.shirt || giftName == R.string.shoe) {
            mGiftNameTextView.setTextColor(Color.GREEN);
        } else if(giftName == R.string.diamond) {
            mGiftNameTextView.setTextColor(Color.DKGRAY);
        }
    }

}
