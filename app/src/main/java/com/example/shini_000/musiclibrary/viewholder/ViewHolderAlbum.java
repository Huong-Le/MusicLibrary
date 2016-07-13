package com.example.shini_000.musiclibrary.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shini_000.musiclibrary.R;
import com.example.shini_000.musiclibrary.model.Album;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shini_000 on 7/12/2016.
 */
public class ViewHolderAlbum {

    //    public ImageView imgAlbum;
//    public TextView txtNameAlbum;
//    public TextView txtNameArtist;
    @Bind(R.id.txtNameAlbum)
    TextView txtNameAlbum;
    @Bind(R.id.txtNameArtist)
    TextView txtNameArtist;
    @Bind(R.id.imgAlbum)
    ImageView imgAlbum;

    View view;

    public ViewHolderAlbum(View view) {
        this.view = view;
        ButterKnife.bind(this, view);
    }

    public void setupWith(Album album, int imageArtist) {
        txtNameAlbum.setText(album.getTitle());
        txtNameArtist.setText(album.getTitle());
        Picasso.with(view.getContext()).load(imageArtist).resize(160, 160).centerCrop().into(imgAlbum);

    }
}
