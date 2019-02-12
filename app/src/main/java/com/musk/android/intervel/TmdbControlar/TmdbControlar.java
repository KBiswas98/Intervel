package com.musk.android.intervel.TmdbControlar;

public class TmdbControlar {
    private String image_base_link;
    private static String API_key = "015f05488218493c7f68362ab87000cd";
    private static int current_page = 1;
    private String sort_by;

    private static String PopularMovieLink = "https://api.themoviedb.org/3/movie/popular?api_key="+API_key+"&language=en-US&page=";

    public static String getPopularMoviesLink(){
        return PopularMovieLink + current_page;
    }

    public static String gotoNextPage(String link){
        ++current_page;
        return PopularMovieLink+current_page;
    }

    public static String gotoPreviousPage(String link){
        --current_page;
        return PopularMovieLink+current_page;
    }
}
