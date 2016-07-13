package com.example.shini_000.musiclibrary.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shini_000.musiclibrary.R;
import com.example.shini_000.musiclibrary.model.Releases;
import com.example.shini_000.musiclibrary.viewholder.ViewHolderAlbum;
import com.squareup.picasso.Picasso;


/**
 * Created by shini_000 on 7/12/2016.
 */
public class AlbumAdapter extends BaseAdapter {

    private Context context;
    private Releases releases;
    LayoutInflater inflater;
    private int imageArtist;


    public AlbumAdapter(Context context, Releases releases, int imageArtist) {
        this.context = context;
        this.releases = releases;
        inflater = LayoutInflater.from(context);
        this.imageArtist = imageArtist;
    }

    @Override
    public int getCount() {
        Log.e("huongle", String.valueOf(releases.getReleases().size()));
        return releases.getReleases().size();
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
            viewHolderAlbum = new ViewHolderAlbum();
            viewHolderAlbum.txtNameAlbum = (TextView) view.findViewById(R.id.txtNameAlbum);
            viewHolderAlbum.txtNameArtist = (TextView) view.findViewById(R.id.txtNameArtist);
            viewHolderAlbum.imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
            view.setTag(viewHolderAlbum);
        } else {
            viewHolderAlbum = (ViewHolderAlbum) view.getTag();
        }
//
        viewHolderAlbum.txtNameAlbum.setText(releases.getReleases().get(position).getTitle());
        viewHolderAlbum.txtNameArtist.setText(releases.getReleases().get(position).getArtist());
        Picasso.with(context) .load(imageArtist) .resize(160, 160) .centerCrop() .into(viewHolderAlbum.imgAlbum);

        return view;
    }
}
