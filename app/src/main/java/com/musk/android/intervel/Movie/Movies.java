package com.musk.android.intervel.Movie;

public class Movies {
    private String movieName;
    private float reating;
    private int thumbnail;

    public Movies()
    {

    }
    public Movies(String movieName, float reating, int thumbnail) {
        this.movieName = movieName;
        this.reating = reating;
        this.thumbnail = thumbnail;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public float getReating() {
        return reating;
    }

    public void setReating(float reating) {
        this.reating = reating;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieName='" + movieName + '\'' +
                ", reating=" + reating +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
