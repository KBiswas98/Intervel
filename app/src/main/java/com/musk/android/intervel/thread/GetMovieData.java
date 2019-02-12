//package com.musk.android.intervel.thread;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.musk.android.intervel.Movie.Movies;
//import com.musk.android.intervel.utils.JsObj;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import javax.net.ssl.HttpsURLConnection;
//
//public class GetMovieData extends AsyncTask<String, Void, String> {
//    private static final String TAG = "GetMovieData";
//        @Override
//        protected String doInBackground(String... strings) {
//            URL url = null;
//            Log.d(TAG, "doInBackground: 1st try");
//            try{
//                url = new URL(strings[0]);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//
//            try{
//                Log.d(TAG, "doInBackground: 2nd try");
//                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
//                InputStream inputStream = urlConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//                String s = bufferedReader.readLine();
//                bufferedReader.close();
//                Log.d(TAG, "doInBackground: kali:"+s);
//                return s;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            try {
//                JSONObject jsonObject = new JSONObject(s);
////                Log.d(TAG, "onPostExecute: movie name: "+jsonObject.getString("original_title"));
//
//                JSONArray jsonArray = jsonObject.getJSONArray("results");
//
//
//                for (int i = 0; i<jsonArray.length(); i++){
//                    JSONObject object = jsonArray.getJSONObject(i);
//
//                    JsObj movie = new JsObj();
//
//                    movie.setTitle(object.getString("title"));
//                    movie.setVoteAverage(object.getDouble("vote_average"));
//
//                    String imageLink = object.getString("poster_path");
//                    String ILink = BaseImageLink.concat(imageLink);
//                    movie.setPosterPath(ILink);
//                    Log.d(TAG, "onPostExecute: posterLink: "+movie.getPosterPath());
//                    moviesList.add(new Movies(movie.getTitle(),movie.getVoteAverage(),movie.getPosterPath()));
//                }
//                Init();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//}
