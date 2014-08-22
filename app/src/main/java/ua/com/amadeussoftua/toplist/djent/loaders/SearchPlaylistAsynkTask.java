package ua.com.amadeussoftua.toplist.djent.loaders;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import de.greenrobot.event.EventBus;
import ua.com.amadeussoftua.toplist.djent.Debug;
import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.db.PlayListDao;
import ua.com.amadeussoftua.toplist.djent.events.BusEventPlaylistsLoaded;
import ua.com.amadeussoftua.toplist.djent.model.Playlist;

/**
 * Created by Artem on 17.08.2014.
 */
public class SearchPlaylistAsynkTask extends AsyncTask<String, List<Playlist>, List<Playlist>> {

    public static final String BUNDLE_KEY_QUERY = "bundle_key_query";

    private final String TAG = "SearchPlaylistDbLoader";

    private TopListApplication application;

    public SearchPlaylistAsynkTask(Context context) {
        super();
        application = (TopListApplication) context.getApplicationContext();
        Debug.logD(TAG, "Create SearchPlaylistDbLoader");
    }

    @Override
    protected List<Playlist> doInBackground(String... strings) {
        PlayListDao dao = application.getDatabaseHelper().getPlayListDao();
        List<Playlist> result = dao.requestSearchWithSort(strings[0]);
        return result;
    }

    @Override
    protected void onPostExecute(List<Playlist> playlists) {
        super.onPostExecute(playlists);
        EventBus.getDefault().post(new BusEventPlaylistsLoaded(playlists));
    }
}
