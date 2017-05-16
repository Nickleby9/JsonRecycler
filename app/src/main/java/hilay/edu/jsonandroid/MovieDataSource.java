package hilay.edu.jsonandroid;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Android2017 on 5/16/2017.
 */

public class MovieDataSource {


    public interface OnDataArrivedListener {
        void onDataArrived(ArrayList<Movie> movies, Exception e);
    }

    public static void getMovies(final OnDataArrivedListener listener) {
        final Thread movieTread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = StreamIO.readWebSite("http://api.androidhive.info/json/movies.json");
                    ArrayList<Movie> movies = parse(json);
                    listener.onDataArrived(movies, null);
                } catch (IOException | JSONException e) {
                    listener.onDataArrived(null, e);
                }
            }
        });
        movieTread.start();
    }

    private static ArrayList<Movie> parse(String json) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<>();
        JSONArray moviesArray = new JSONArray(json);
        for (int i = 0; i < moviesArray.length(); i++) {
            ArrayList<String> genres = new ArrayList<String>();

            JSONObject movieObject = moviesArray.getJSONObject(i);
            String title = movieObject.getString("title");
            String image = movieObject.getString("image");
            int releaseYear = movieObject.getInt("releaseYear");
            double rating = movieObject.getDouble("rating");
            JSONArray genresArray = movieObject.getJSONArray("genre");
            for (int j = 0; j < genresArray.length(); j++) {
                String genre = genresArray.getString(j);
                genres.add(genre);
            }
            Movie movie = new Movie(title, image, genres, releaseYear, rating);
            movies.add(movie);
        }
        return movies;
    }

}
