package com.example.shini_000.musiclibrary.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.shini_000.musiclibrary.R;
import com.example.shini_000.musiclibrary.adapter.AlbumAdapter;
import com.example.shini_000.musiclibrary.api.ResultData;
import com.example.shini_000.musiclibrary.callback.ResponseApiListner;
import com.example.shini_000.musiclibrary.constant.Variable;
import com.example.shini_000.musiclibrary.model.Artist;
import com.example.shini_000.musiclibrary.model.Releases;


public class AlbumActivity extends Activity {

    private ListView listView;
    private Releases releases;
    private AlbumAdapter albumAdapter;
    Artist artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        handleIntent();
        initView();
        initData();

        releases = new Releases();
        ResultData request = new ResultData(this, releases, listView, artist.getImageArtist());
        request.execute(artist.getLink());
        request.setCallback(new ResponseApiListner<Releases>() {
            @Override
            public void onResponse(Releases response) {
                albumAdapter.setReleases(response);
                albumAdapter.notifyDataSetChanged();
            }
        });


    }

    private void handleIntent() {
        artist = getIntent().getParcelableExtra(Variable.ARTIST);
    }

    private void initData() {

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        albumAdapter = new AlbumAdapter(this, artist.getImageArtist());
        listView.setAdapter(albumAdapter);
    }
}
