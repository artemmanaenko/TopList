package ua.com.amadeussoftua.toplist.djent.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import ua.com.amadeussoftua.toplist.djent.model.Playlist;

/**
 * Created by Artem on 12.08.2014.
 */
public class HomePageAdapter extends BaseAdapter {

    private final int ITEM_TYPE_COUNT = 2;
    private final int TYPE_ITEM = 0;
    private final int TYPE_BANNER = 1;
    private final int BANNER_INTERVAL = 5;

    private List<Playlist> items;

    private Context context;

    public HomePageAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Playlist> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (items == null || items.isEmpty())
            return 0;
        int bannersCount = items.size() / BANNER_INTERVAL;
        return items.size() + bannersCount;
    }

    @Override
    public Object getItem(int position) {
        if (getItemViewType(position) == TYPE_ITEM) {
            int bannersCount = position / BANNER_INTERVAL;
            int realPosition = position - bannersCount;
            return items.get(realPosition);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_ITEM)
            return getItemView(position, view, viewGroup);
        else if (itemViewType == TYPE_BANNER)
            return getBannerView(position, view, viewGroup);
        return null;
    }

    private View getItemView(int position, View view, ViewGroup viewGroup) {
        return view;
    }

    private View getBannerView(int position, View view, ViewGroup viewGroup) {
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        if (position != 0 && position % BANNER_INTERVAL == 0)
            return TYPE_BANNER;
        else
            return TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_TYPE_COUNT;
    }
}
