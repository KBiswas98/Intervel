package com.musk.android.intervel.utils;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

public class SpacesGriedItems extends RecyclerView.ItemDecoration {
    private static final String TAG = "SpacesGriedItems";
    private int space;
    private int calltime;
    private int _callLimit = 2;

    public SpacesGriedItems(int space, int callTime){
        this.space = space;
        this.calltime = callTime;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
        Log.d(TAG, "getItemOffsets: calltime: "+calltime);
        if (calltime < _callLimit) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
        }
    }
}
