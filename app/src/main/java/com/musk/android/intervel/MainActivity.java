package com.musk.android.intervel;

import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.musk.android.intervel.Movie.Movies;
import com.musk.android.intervel.utils.CustomScrollerListener;
import com.musk.android.intervel.utils.RecyclerAdaptar;
import com.musk.android.intervel.utils.SpacesGriedItems;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    List<Movies> moviesList;
    private static int Cunt;
    private static int width;
    private static int height;

    //----------const----------
    private int PIXEL_DEVISOR = 240;
    private int GRIED_SPACING = 10;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cunt = 0;
        mContext = MainActivity.this;

        moviesList = new ArrayList<>();
        moviesList.add(new Movies("starwar",7.5f,R.drawable.starwar));
        moviesList.add(new Movies("avenger",8.0f,R.drawable.avenger));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("venom",9.5f,R.drawable.venom));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("venom",9.5f,R.drawable.venom));
        moviesList.add(new Movies("starwar",7.5f,R.drawable.starwar));
        moviesList.add(new Movies("avenger",8.0f,R.drawable.avenger));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("starwar",7.5f,R.drawable.starwar));
        moviesList.add(new Movies("avenger",8.0f,R.drawable.avenger));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("venom",9.5f,R.drawable.venom));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("venom",9.5f,R.drawable.venom));
        moviesList.add(new Movies("starwar",7.5f,R.drawable.starwar));
        moviesList.add(new Movies("avenger",8.0f,R.drawable.avenger));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("starwar",7.5f,R.drawable.starwar));
        moviesList.add(new Movies("avenger",8.0f,R.drawable.avenger));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("venom",9.5f,R.drawable.venom));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));
        moviesList.add(new Movies("venom",9.5f,R.drawable.venom));
        moviesList.add(new Movies("starwar",7.5f,R.drawable.starwar));
        moviesList.add(new Movies("avenger",8.0f,R.drawable.avenger));
        moviesList.add(new Movies("war",7.5f,R.drawable.war));
        moviesList.add(new Movies("blade",6.5f,R.drawable.blade));

        Log.d(TAG, "onCreate length of movie aray: "+moviesList.size());

        Init();
    }

    private void Init()
    {
        Cunt++;

        int widths = getResources().getDisplayMetrics().widthPixels;
        int noColum = widths/PIXEL_DEVISOR;

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
        RecyclerAdaptar recyclerAdaptar = new RecyclerAdaptar(mContext,moviesList);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, noColum));
        recyclerView.setAdapter(recyclerAdaptar);
        recyclerView.addItemDecoration(new SpacesGriedItems(GRIED_SPACING,Cunt));
        recyclerView.addOnScrollListener(new CustomScrollerListener());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Init();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Init();
        }
    }
































    //    static public class MyAsynkTask extends AsyncTask<Void, Void, String> {
//
//        @Override
//        protected String doInBackground(Void... voids) {
//            if(width> height)
//                colCunt = 4;
//            colCunt = 3;
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "Executed";
//        }
//    }













}
