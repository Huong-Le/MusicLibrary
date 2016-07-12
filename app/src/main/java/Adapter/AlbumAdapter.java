package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shini_000.musiclibrary.R;
import com.squareup.picasso.Picasso;

import Objects.Artist;
import Objects.ListALbum;
import ViewHolder.ViewHolderAlbum;

/**
 * Created by shini_000 on 7/12/2016.
 */
public class AlbumAdapter extends BaseAdapter {

    private Context context;
    private ListALbum listALbum;
    LayoutInflater inflater;
    private int imageArtist;


    public AlbumAdapter(Context context, ListALbum listALbum, int imageArtist) {
        this.context = context;
        this.listALbum = listALbum;
        inflater = LayoutInflater.from(context);
        this.imageArtist = imageArtist;
    }

    @Override
    public int getCount() {
        Log.e("huongle", String.valueOf(listALbum.getReleases().size()));
        return listALbum.getReleases().size();
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
            view = inflater.inflate(R.layout.album, null);
            viewHolderAlbum = new ViewHolderAlbum();
            viewHolderAlbum.txtNameAlbum = (TextView) view.findViewById(R.id.txtNameAlbum);
            viewHolderAlbum.txtNameArtist = (TextView) view.findViewById(R.id.txtNameArtist);
            viewHolderAlbum.imgAlbum = (ImageView) view.findViewById(R.id.imgAlbum);
            view.setTag(viewHolderAlbum);
        } else {
            viewHolderAlbum = (ViewHolderAlbum) view.getTag();
        }
//
        viewHolderAlbum.txtNameAlbum.setText(listALbum.getReleases().get(position).getTitle());
        viewHolderAlbum.txtNameArtist.setText(listALbum.getReleases().get(position).getArtist());
        Picasso.with(context) .load(imageArtist) .resize(160, 160) .centerCrop() .into(viewHolderAlbum.imgAlbum);

        return view;
    }
}
