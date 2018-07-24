package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
//declaration
    ListView lvMovies;
    ArrayList<MovieItem> alMovies;
    CustomAdapter caMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//linking
        lvMovies=findViewById(R.id.listViewMovies);
        alMovies=new ArrayList<>();

//seeting year to display
        Calendar date1 = Calendar.getInstance();
        date1.set(2014,10,15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,4,15);
//adding item to arraylist
        MovieItem item1=new MovieItem("The Avengers",
                "2012", "pg13", "Action | Sci-Fi", date1, "Golden Village - Bishan", "Nick fury of S.H.I.E.L.D assembles a team of superheroes to save the planet from Loki and his army.");

        MovieItem item2=new MovieItem("Planes",
                "2013", "pg", "Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
//adding the above object
        alMovies.add(item1);
        alMovies.add(item2);

        caMovies= new CustomAdapter(this,R.layout.layout01,alMovies);
        lvMovies.setAdapter(caMovies);

//what to see when clicking
        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), moviedetailsactivity.class);
                MovieItem currentMovie = alMovies.get(position);
//display things
                intent.putExtra("title", currentMovie.getTitle());
                intent.putExtra("year", currentMovie.getYear());
                intent.putExtra("rated", currentMovie.getRated());
                intent.putExtra("genre", currentMovie.getGenre());
                intent.putExtra("watchDate", currentMovie.getWatched_on_String());
                intent.putExtra("theatre", currentMovie.getIn_theatre());
                intent.putExtra("desc", currentMovie.getDescription());

                startActivity(intent);
            }
        });
    }
}
