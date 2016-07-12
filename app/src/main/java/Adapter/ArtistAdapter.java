package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shini_000.musiclibrary.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Objects.Artist;
import ViewHolder.ViewHolderArtist;

/**
 * Created by shini_000 on 7/12/2016.
 */
public class ArtistAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Artist> listArtist;

    public ArtistAdapter(Context context, ArrayList<Artist> listArtist) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.listArtist = listArtist;
    }

    @Override
    public int getCount() {
        return listArtist.size();
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
        ViewHolderArtist viewHolderArtist;

        if( view == null ) {
            view = inflater.inflate(R.layout.artist, null);
            viewHolderArtist = new ViewHolderArtist();
            viewHolderArtist.imgNameArtist = (ImageView) view.findViewById(R.id.imgArtist);
            viewHolderArtist.txtNameArtist = (TextView) view.findViewById(R.id.txtNameArtist);
            view.setTag(viewHolderArtist);
        }
        else {
            viewHolderArtist = (ViewHolderArtist)view.getTag();
        }

        viewHolderArtist.txtNameArtist.setText(listArtist.get(position).getNameArtist());
        Picasso.with(context) .load(listArtist.get(position).getImageArtist()) .resize(360, 400) .centerCrop() .into(viewHolderArtist.imgNameArtist);
        return view;
    }
}
