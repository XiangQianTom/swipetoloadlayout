package com.si.swipetoloadlayout.demo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.si.swipetoloadlayout.SwipeRefreshTrigger;
import com.si.swipetoloadlayout.SwipeTrigger;

public class RefreshView extends TextView implements SwipeRefreshTrigger, SwipeTrigger {
    private static final String TAG = RefreshView.class.getSimpleName();

    public RefreshView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setText(getResources().getString(R.string.refrshing));
    }

    @Override
    public void onRefresh() {
        Log.e(TAG, "onRefresh: ");
    }

    @Override
    public void onPrepare() {
        Log.e(TAG, "onPrepare: ");
    }

    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {
    }

    @Override
    public void onRelease() {
        Log.e(TAG, "onRelease: ");
    }

    @Override
    public void onComplete() {
        Log.e(TAG, "onComplete: ");
    }

    @Override
    public void onReset() {
        Log.e(TAG, "onReset: ");
    }
}
