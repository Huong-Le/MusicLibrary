package com.example.shini_000.musiclibrary.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.shini_000.musiclibrary.R;
import com.example.shini_000.musiclibrary.adapter.ArtistAdapter;
import com.example.shini_000.musiclibrary.constant.Constant;
import com.example.shini_000.musiclibrary.model.Artist;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    private GridView gridView;
    private ArtistAdapter artistAdapter;
    private ArrayList<Artist> listArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        listArtist = new ArrayList<Artist>();
        listArtist.add(new Artist(R.drawable.adele, "Adele", Constant.API_ADELE));
        listArtist.add(new Artist(R.drawable.avril_lavigne, "Arvil Lavigne", Constant.API_AVRIL_LAVIGNE));
        listArtist.add(new Artist(R.drawable.bruno_mars, "Bruno Mars", Constant.API_BRUNO_MARS));
        listArtist.add(new Artist(R.drawable.eminem, "Eminem", Constant.API_EMINEM));
        listArtist.add(new Artist(R.drawable.katy_perry, "Katy Perry", Constant.API_KATY_PERRY));
        listArtist.add(new Artist(R.drawable.maroon5, "Maroon 5", Constant.API_MAROON5));
        listArtist.add(new Artist(R.drawable.one_direction, "One Direction", Constant.API_ONE_DIRECTION));
        listArtist.add(new Artist(R.drawable.taylor_swift, "Taylor Swift", Constant.API_TAYLOR_SWIFT));

        gridView = (GridView)findViewById(R.id.gridView);

        artistAdapter = new ArtistAdapter(ArtistActivity.this, listArtist);
        gridView.setAdapter(artistAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AlbumActivity.class);
                intent.putExtra(Constant.INTENT_ARTIST, listArtist.get(position));
                startActivity(intent);
            }
        });
    }
}
