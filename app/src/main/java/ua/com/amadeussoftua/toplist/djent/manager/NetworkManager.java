package ua.com.amadeussoftua.toplist.djent.manager;

import android.content.Context;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.db.ArtistsDao;
import ua.com.amadeussoftua.toplist.djent.db.PlayListDao;
import ua.com.amadeussoftua.toplist.djent.db.SongsDao;
import ua.com.amadeussoftua.toplist.djent.model.Artist;
import ua.com.amadeussoftua.toplist.djent.model.Playlist;
import ua.com.amadeussoftua.toplist.djent.model.Song;

/**
 * Created by Artem on 16.08.2014.
 */
public class NetworkManager {

    private TopListApplication application;

    public NetworkManager(Context context) {
        this.application = (TopListApplication) context.getApplicationContext();
    }

    public void requestAllPlayLists() {
        BackendlessDataQuery query = new BackendlessDataQuery();
        Backendless.Data.of(Playlist.class).find(query, getPlayListReceivedCallback());
    }

    public void requestAllArtists() {
        BackendlessDataQuery query = new BackendlessDataQuery();
        Backendless.Data.of(Artist.class).find(query, getArtistsReceivedCallback());
    }

    public void requestAllSongs() {
        BackendlessDataQuery query = new BackendlessDataQuery();
        Backendless.Data.of(Song.class).find(query, getSongsReceivedCallback());
    }

    private BackendlessCallback getSongsReceivedCallback() {
        return new BackendlessCallback<BackendlessCollection<Song>>() {

            @Override
            public void handleResponse(BackendlessCollection<Song> response) {
                SongsDao dao = application.getDatabaseHelper().getSongsDao();
                dao.setIncomingData(response.getData());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                super.handleFault(fault);
            }
        };
    }

    private BackendlessCallback getPlayListReceivedCallback() {
        return new BackendlessCallback<BackendlessCollection<Playlist>>() {

            @Override
            public void handleResponse(BackendlessCollection<Playlist> response) {
                PlayListDao dao = application.getDatabaseHelper().getPlayListDao();
                dao.setIncomingData(response.getData());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                super.handleFault(fault);
            }
        };
    }

    private BackendlessCallback getArtistsReceivedCallback() {
        return new BackendlessCallback<BackendlessCollection<Artist>>() {

            @Override
            public void handleResponse(BackendlessCollection<Artist> response) {
                ArtistsDao dao = application.getDatabaseHelper().getArtistsDao();
                dao.setIncomingData(response.getData());
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                super.handleFault(fault);
            }
        };
    }


}
