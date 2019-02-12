package com.musk.android.intervel;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.musk.android.intervel.Movie.Movies;
import com.musk.android.intervel.TmdbControlar.TmdbControlar;
import com.musk.android.intervel.utils.JsObj;
import com.musk.android.intervel.utils.RecyclerAdaptar;
import com.musk.android.intervel.utils.SpacesGriedItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

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
    private String BaseImageLink = "https://image.tmdb.org/t/p/w500";
    private Bitmap img;

    private Parcelable recycle;
    private int cos;
    ArrayList<JsObj> movieDetails ;

    ProgressBar progressBar;
    ProgressBar moviePostarDownoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.recyclearViewProgressbar);


        movieDetails = new ArrayList<>();
        moviesList = new ArrayList<>();

        Cunt = 0;
        mContext = MainActivity.this;

        new GetmovieData().execute(TmdbControlar.getPopularMoviesLink());

        Log.d(TAG, "onCreate length of movie aray: "+moviesList.size());

        Init();
    }


    private class GetmovieData extends AsyncTask<String, Integer, String>{

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            Log.d(TAG, "doInBackground: 1st try");
            try{
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try{
                Log.d(TAG, "doInBackground: 2nd try");
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String s = bufferedReader.readLine();
                bufferedReader.close();
                Log.d(TAG, "doInBackground: kali:"+s);
                return s;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject jsonObject = new JSONObject(s);
//                Log.d(TAG, "onPostExecute: movie name: "+jsonObject.getString("original_title"));

                JSONArray jsonArray = jsonObject.getJSONArray("results");


                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject object = jsonArray.getJSONObject(i);

                    JsObj movie = new JsObj();

                    movie.setTitle(object.getString("title"));
                    movie.setVoteAverage(object.getDouble("vote_average"));

                    String imageLink = object.getString("poster_path");
                    String ILink = BaseImageLink.concat(imageLink);
                    movie.setPosterPath(ILink);
                    Log.d(TAG, "onPostExecute: posterLink: "+movie.getPosterPath());
                    moviesList.add(new Movies(movie.getTitle(),movie.getVoteAverage(),movie.getPosterPath()));
                }
                Init();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

   private void Init()
    {
        Cunt++;

        int widths = getResources().getDisplayMetrics().widthPixels;
        int noColum = widths/PIXEL_DEVISOR;

        moviePostarDownoad = (ProgressBar) findViewById(R.id.moviePosterDownload);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
//        RecyclerAdaptar recyclerAdaptar = new RecyclerAdaptar(mContext,moviesList,moviePostarDownoad);
        RecyclerAdaptar recyclerAdaptar = new RecyclerAdaptar(mContext,moviesList);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, noColum));
        recyclerView.setAdapter(recyclerAdaptar);
        recyclerView.addItemDecoration(new SpacesGriedItems(GRIED_SPACING,Cunt));
//        recyclerView.addOnScrollListener(new CustomScrollerListener());
//        if (recycle!=null)
            recyclerView.getLayoutManager().onRestoreInstanceState(recycle);
        final Boolean[] loading = {true};
        final int[] pastVisibalsItem = new int[1];
        final int[] visibalItemCount = new int[1];
        final int[] totalItemCount = new int[1];
        final int[] sos = new int[1];
        final Boolean[] scrolling = {false};

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if ( dy > 0){
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    visibalItemCount[0] =linearLayoutManager.getChildCount();
                    totalItemCount[0] = linearLayoutManager.getItemCount();
                    pastVisibalsItem[0] = linearLayoutManager.findFirstVisibleItemPosition();
                    sos[0] = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                    cos = getmax(cos,sos[0]);
                    linearLayoutManager.setInitialPrefetchItemCount(cos);

                    recycle = recyclerView.getLayoutManager().onSaveInstanceState();
                    Log.d(TAG, "onScrolled: visibalItem: "+visibalItemCount[0]+" total item: "+totalItemCount[0]+" pastvisibal: "+pastVisibalsItem[0]+" sos : "+sos[0]+" cos: "+cos);
                    scrolling[0] = true;
                }


                if (loading[0] && scrolling[0]){
                    if ((totalItemCount[0] - 20) < sos[0]){
                        Log.d(TAG, "onScrolled: loading: "+loading[0]);
                        loading[0] = false;
                        Toast.makeText(MainActivity.this, "Loading..", Toast.LENGTH_SHORT).show();
//                        recycle = recyclerView.getLayoutManager().onSaveInstanceState();
                        new GetmovieData().execute(TmdbControlar.gotoNextPage(TmdbControlar.getPopularMoviesLink()));
                    }
                }



            }
        });
    }

    public int getmax(int a, int b){
        if (a>b)
            return a;
        return b;
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
