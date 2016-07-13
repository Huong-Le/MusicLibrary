package com.example.shini_000.musiclibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.shini_000.musiclibrary.R;
import com.example.shini_000.musiclibrary.model.Releases;
import com.example.shini_000.musiclibrary.viewholder.ViewHolderAlbum;


/**
 * Created by shini_000 on 7/12/2016.
 */
public class AlbumAdapter extends BaseAdapter {

    private Context context;
    private Releases releases;
    LayoutInflater inflater;
    private int imageArtist;

    public void setReleases(Releases releases) {
        this.releases = releases;
    }

    public AlbumAdapter(Context context, Releases releases, int imageArtist) {
        this.context = context;
        this.releases = releases;
        inflater = LayoutInflater.from(context);
        this.imageArtist = imageArtist;
    }

    public AlbumAdapter(Context context, int imageArtist) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.imageArtist = imageArtist;
    }

    @Override
    public int getCount() {
//        Log.e("huongle", String.valueOf(releases.getReleases().size()));
        return releases != null ? releases.getReleases().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolderAlbum viewHolderAlbum;

        if (view == null) {
            view = inflater.inflate(R.layout.item_album, null);
            viewHolderAlbum = new ViewHolderAlbum(view);
            view.setTag(viewHolderAlbum);
        } else {
            viewHolderAlbum = (ViewHolderAlbum) view.getTag();
        }
        viewHolderAlbum.setupWith(releases.getReleases().get(position), imageArtist);
        return view;
    }
}
