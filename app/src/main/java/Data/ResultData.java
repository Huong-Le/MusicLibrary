package Data;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import Adapter.AlbumAdapter;
import Objects.Artist;
import Objects.ListALbum;
import ViewHolder.ViewHolderAlbum;

/**
 * Created by shini_000 on 7/12/2016.
 */
public class ResultData extends AsyncTask<String, Void, ListALbum> {

    private Activity activity;
    private ListALbum listALbum;
    private ListView listView;
    private AlbumAdapter albumAdapter;
    private int imageArtist;

    public ResultData(Activity activity, ListALbum listALbum, ListView listView, int imageArtist) {
        this.activity = activity;
        this.listALbum = listALbum;
        this.listView = listView;
        this.imageArtist = imageArtist;
    }

    @Override
    protected ListALbum doInBackground(String... params) {
        try {
            URL url = new URL(params[0]);
            listALbum = new Gson().fromJson(new InputStreamReader(url.openStream()), ListALbum.class);
                Log.e("huongle", String.valueOf(listALbum.getReleases().size()));
            return listALbum;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ListALbum listALbum) {
        super.onPostExecute(listALbum);
        albumAdapter = new AlbumAdapter(activity, listALbum, imageArtist);
        listView.setAdapter(albumAdapter);
    }
}
