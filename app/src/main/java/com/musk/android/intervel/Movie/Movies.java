package com.musk.android.intervel.Movie;

public class Movies {
    private String movieName;
    private double reating;
    private String thumbnailLink;

    public Movies()
    {

    }
    public Movies(String movieName, double reating, String thumbnailLink) {
        this.movieName = movieName;
        this.reating = reating;
        this.thumbnailLink = thumbnailLink;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getReating() {
        return reating;
    }

    public void setReating(double reating) {
        this.reating = reating;
    }

    public String getThumbnail() {
        return thumbnailLink;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnailLink = thumbnail;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieName='" + movieName + '\'' +
                ", reating=" + reating +
                ", thumbnail=" + thumbnailLink +
                '}';
    }
}


































/*
package com.musk.android.intervel.Movie;

public class Movies {
    private String movieName;
    private double reating;
    private int thumbnail;

    public Movies()
    {

    }
    public Movies(String movieName, double reating, int thumbnail) {
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

    public double getReating() {
        return reating;
    }

    public void setReating(double reating) {
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

 */