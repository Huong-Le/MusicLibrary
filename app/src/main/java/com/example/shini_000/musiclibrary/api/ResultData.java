package com.example.shini_000.musiclibrary.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import com.example.shini_000.musiclibrary.adapter.AlbumAdapter;
import com.example.shini_000.musiclibrary.callback.ResponseApiListner;
import com.example.shini_000.musiclibrary.model.Releases;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shini_000 on 7/12/2016.
 */
public class ResultData extends AsyncTask<String, Void, Releases> {

    private Activity activity;
    private Releases releases;
    private ListView listView;
    private AlbumAdapter albumAdapter;
    private int imageArtist;

    ResponseApiListner<Releases> callback;

    public void setCallback(ResponseApiListner<Releases> callback) {
        this.callback = callback;
    }

    public ResultData(Activity activity, Releases releases, ListView listView, int imageArtist) {
        this.activity = activity;
        this.releases = releases;
        this.listView = listView;
        this.imageArtist = imageArtist;
    }

    @Override
    protected Releases doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            releases = new Gson().fromJson(new InputStreamReader(url.openStream()), Releases.class);
                Log.e("huongle", String.valueOf(releases.getReleases().size()));
            return releases;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Releases releases) {
        super.onPostExecute(releases);
        callback.onResponse(releases);
    }
}
