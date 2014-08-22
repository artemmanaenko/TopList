package ua.com.amadeussoftua.toplist.djent.events;

import java.util.List;

import ua.com.amadeussoftua.toplist.djent.model.Playlist;

/**
 * Created by Artem on 18.08.2014.
 */
public class BusEventPlaylistsLoaded {

    private List<Playlist> playlists;

    public BusEventPlaylistsLoaded(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
}
