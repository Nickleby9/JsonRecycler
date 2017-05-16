package hilay.edu.jsonandroid;

import java.util.ArrayList;

/**
 * Created by Android2017 on 5/16/2017.
 */

public class Movie {
    private final String title, image;
    private final ArrayList<String> genres;
    private final int releaseYear;
    private final double rating;

//    public Movie(String title, String image, int releaseYear, double rating, String... genres) {
//        this.title = title;
//        this.image = image;
//        this.releaseYear = releaseYear;
//        this.rating = rating;
//        for (int i = 0; i < genres.length; i++) {
//            this.genres.add(genres[i]);
//        }
//    }

    public Movie(String title, String image, ArrayList<String> genres, int releaseYear, double rating) {
        this.title = title;
        this.image = image;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", genres=" + genres +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}
