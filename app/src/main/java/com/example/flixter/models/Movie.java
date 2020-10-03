package com.example.flixter.models;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {
    String movieId ;
    String posterPath ;
    String backdropPath;
    String title;
    String overview ;
    float rating;

    public Movie(){

    }
    public  Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString(("poster_path"));
        title = jsonObject.getString("title");
        overview = jsonObject.getString(("overview"));
        rating = (float)jsonObject.getDouble("vote_average");
        movieId = jsonObject.getString("id");
    }
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for(int i = 0 ; i<movieJsonArray.length(); i++)
         {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }
    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getOverview() {
        return overview;
    }

    public float getRating() {
        return rating;
    }

    public String getMovieId() {
        return movieId;
    }
}
