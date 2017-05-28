package hilay.edu.jsonandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieDataSource.OnDataArrivedListener {
    ArrayList<Movie> movies = new ArrayList<>();
    RecyclerView rvMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvMovies = (RecyclerView) findViewById(R.id.rvMovies);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        MovieDataSource.fetchMovies(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataArrived(final ArrayList<Movie> movies, final Exception e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MovieAdapter adapter = new MovieAdapter(MainActivity.this, MovieDataSource.getMovies());
                rvMovies.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvMovies.setAdapter(adapter);
            }
        });
    }
}
