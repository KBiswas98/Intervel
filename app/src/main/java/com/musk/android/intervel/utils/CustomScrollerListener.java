package com.musk.android.intervel.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

public class CustomScrollerListener extends RecyclerView.OnScrollListener {
    private static final String TAG = "CustomScrollerListener";

    private RelativeLayout top_actionbar;
    private View view;

    public CustomScrollerListener(RelativeLayout actionbar,View view)
    {
        this.top_actionbar = actionbar;
        this.view = view;
    }
    public void onScrollStageChange(RecyclerView recyclerView, int newState){
        switch (newState){
            case RecyclerView.SCROLL_STATE_IDLE:
                Log.d(TAG, "onScrollStageChange: "+"recyclear view scrolling");
                break;
            case RecyclerView.SCROLL_STATE_DRAGGING:
                Log.d(TAG, "onScrollStageChange: start dadding");
                break;
            case RecyclerView.SCROLL_STATE_SETTLING:
                Log.d(TAG, "onScrollStageChange: scroll stting");
                break;
        }
    }

    public void hideTopActionBar(){
//        TranslateAnimation animators = new TranslateAnimation().ofFloat(view,"translationY",100f);
//        animator.setDuration(2000);
//        top_actionbar.startAnimation(animator);
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy)
    {
        if (dx>0){
            Log.d(TAG, "onScrolled: scroll right");
        } else if (dx<0) {
            Log.d(TAG, "onScrolled: scroll left");
        } else
            Log.d(TAG, "onScrolled: no horiontal scroll");
        if (dy > 0){
            Log.d(TAG, "onScrolled: scrol downwords");
        } else if (dy < 0){
            Log.d(TAG, "onScrolled: scrol upwords");
        } else
            Log.d(TAG, "onScrolled: no vertical scroll");
    }
}
