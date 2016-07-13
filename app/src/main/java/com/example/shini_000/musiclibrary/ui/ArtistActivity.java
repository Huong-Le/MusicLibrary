package com.example.shini_000.musiclibrary.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import com.example.shini_000.musiclibrary.R;
import com.example.shini_000.musiclibrary.adapter.ArtistAdapter;

import com.example.shini_000.musiclibrary.model.Artist;
import com.example.shini_000.musiclibrary.constant.Variable;

public class ArtistActivity extends AppCompatActivity {

    private GridView gridView;
    private ArtistAdapter artistAdapter;
    private ArrayList<Artist> listArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        listArtist = new ArrayList<Artist>();
        listArtist.add(new Artist(R.drawable.adele, "Adele", Variable.ADELE));
        listArtist.add(new Artist(R.drawable.avril_lavigne, "Arvil Lavigne", Variable.AVRIL_LAVIGNE));
        listArtist.add(new Artist(R.drawable.bruno_mars, "Bruno Mars", Variable.BRUNO_MARS));
        listArtist.add(new Artist(R.drawable.eminem, "Eminem", Variable.EMINEM));
        listArtist.add(new Artist(R.drawable.katy_perry, "Katy Perry", Variable.KATY_PERRY));
        listArtist.add(new Artist(R.drawable.maroon5, "Maroon 5", Variable.MAROON5));
        listArtist.add(new Artist(R.drawable.one_direction, "One Direction", Variable.ONE_DIRECTION));
        listArtist.add(new Artist(R.drawable.taylor_swift, "Taylor Swift", Variable.TAYLOR_SWIFT));

        gridView = (GridView)findViewById(R.id.gridView);

        artistAdapter = new ArtistAdapter(ArtistActivity.this, listArtist);
        gridView.setAdapter(artistAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AlbumActivity.class);
                Log.e("huongle", "skdjfsd");
                intent.putExtra("item_artist", listArtist.get(position));
                startActivity(intent);
            }
        });
    }
}
