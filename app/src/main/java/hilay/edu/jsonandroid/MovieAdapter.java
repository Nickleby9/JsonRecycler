package hilay.edu.jsonandroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Hilay on 18-מאי-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Movie> data;

    public MovieAdapter(Context context, List<Movie> data) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.movie, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = data.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvReleaseYear.setText(String.valueOf(movie.getReleaseYear()));
//        holder.ivThumb.setImageBitmap(getImageBitmap(movie.getImage()));
        holder.tvRating.setText(String.valueOf(movie.getRating()));
        holder.tvGenres.setText(movie.getGenres().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvGenres, tvReleaseYear, tvRating;
        ImageView ivThumb;

        public MovieViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvGenres = (TextView) itemView.findViewById(R.id.tvGenres);
            ivThumb = (ImageView) itemView.findViewById(R.id.ivThumb);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            tvReleaseYear = (TextView) itemView.findViewById(R.id.tvReleaseYear);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Movie movie = data.get(position);


//                    Intent intent = new Intent(context, DetailsActivity.class);
//                    intent.putExtra("Song", movie);
//                    context.startActivity(intent);
                }
            });
        }
    }


}
