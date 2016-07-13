package com.example.shini_000.musiclibrary.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.shini_000.musiclibrary.R;
import com.example.shini_000.musiclibrary.adapter.AlbumAdapter;
import com.example.shini_000.musiclibrary.api.ResultData;
import com.example.shini_000.musiclibrary.model.Artist;
import com.example.shini_000.musiclibrary.model.Releases;


public class AlbumActivity extends Activity {

    private ListView listView;
    private Releases releases;
    private AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Intent intent = getIntent();
        Artist artist = intent.getParcelableExtra("item_artist");

        listView = (ListView) findViewById(R.id.listView);
        releases = new Releases();
        new ResultData(this, releases, listView, artist.getImageArtist()).execute(artist.getLink());
    }
}
