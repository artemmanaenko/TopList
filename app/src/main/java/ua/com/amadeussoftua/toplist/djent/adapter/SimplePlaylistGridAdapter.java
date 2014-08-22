package ua.com.amadeussoftua.toplist.djent.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ua.com.amadeussoftua.toplist.djent.R;
import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.db.FavoriteDao;
import ua.com.amadeussoftua.toplist.djent.model.Playlist;

/**
 * Created by Artem on 12.08.2014.
 */
public class SimplePlaylistGridAdapter extends BaseAdapter {

    private List<Playlist> playLists = new ArrayList<Playlist>();
    private FavoriteDao playListDao;
    private TopListApplication application;

    public SimplePlaylistGridAdapter(Context context) {
        application = (TopListApplication) context.getApplicationContext();
        playListDao = application.getDatabaseHelper().getFavoritesDao();
    }

    @Override
    public int getCount() {
        return playLists.size();
    }

    @Override
    public Playlist getItem(int position) {
        return playLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(application).inflate(R.layout.list_item_playlist_simple, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.playlist_name);
            viewHolder.photo = (ImageView) view.findViewById(R.id.playlist_image);
            viewHolder.favorite = (ImageView) view.findViewById(R.id.favorite);
            viewHolder.listeners = (TextView) view.findViewById(R.id.listeners_count);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Playlist playList = getItem(position);
        boolean isFavorite = playListDao.isFavorite(playList.getId());
        int imageRes = isFavorite ? R.drawable.ic_favorite_normal : R.drawable.ic_favorite_checked;
        viewHolder.favorite.setImageResource(imageRes);
        viewHolder.name.setText(playList.getName());
        viewHolder.listeners.setText(Integer.toString(playList.getListeners()));
        Picasso.with(application).load(playList.getImageUrl()).into(viewHolder.photo);
        return view;
    }

    private class ViewHolder {
        TextView name;
        TextView listeners;
        ImageView photo;
        ImageView favorite;
    }

    public void setPlayLists(List<Playlist> playLists) {
        this.playLists = playLists;
        notifyDataSetChanged();
    }
}
