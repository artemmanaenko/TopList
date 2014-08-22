package ua.com.amadeussoftua.toplist.djent.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ua.com.amadeussoftua.toplist.djent.Debug;
import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.model.Artist;
import ua.com.amadeussoftua.toplist.djent.model.FavoriteItem;
import ua.com.amadeussoftua.toplist.djent.model.Playlist;
import ua.com.amadeussoftua.toplist.djent.model.Song;

/**
 * Created by Artem on 16.08.2014.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "playlists.db";
    private static final int DATABASE_VERSION = 1;

    private TopListApplication application;

    private PlayListDao playListDao;
    private ArtistsDao artistsDao;
    private SongsDao songsDao;
    private FavoriteDao favoritesDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        application = (TopListApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Debug.logI(TAG, "onCreate");
            TableUtils.createTable(connectionSource, Playlist.class);
            TableUtils.createTable(connectionSource, Song.class);
            TableUtils.createTable(connectionSource, Artist.class);
            TableUtils.createTable(connectionSource, FavoriteItem.class);
        } catch (SQLException e) {
            Debug.logE(TAG, "Can't create database");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        //TODO
    }

    @Override
    public void close() {
        super.close();
        playListDao = null;
        artistsDao = null;
        songsDao = null;
        favoritesDao = null;
    }

    private PlayListDao createPlayListDao() {
        RuntimeExceptionDao<Playlist, Integer> dao = getRuntimeExceptionDao(Playlist.class);
        return new PlayListDao(application, dao);
    }

    private ArtistsDao createArtistsDao() {
        RuntimeExceptionDao<Artist, Integer> dao = getRuntimeExceptionDao(Artist.class);
        return new ArtistsDao(application, dao);
    }

    private SongsDao createSongsDao() {
        RuntimeExceptionDao<Song, Integer> dao = getRuntimeExceptionDao(Song.class);
        return new SongsDao(application, dao);
    }

    private FavoriteDao createFavoritesDao() {
        RuntimeExceptionDao<FavoriteItem, Integer> dao = getRuntimeExceptionDao(FavoriteItem.class);
        return new FavoriteDao(application, dao);
    }

    public PlayListDao getPlayListDao() {
        if (playListDao == null)
            playListDao = createPlayListDao();
        return playListDao;
    }

    public ArtistsDao getArtistsDao() {
        if (artistsDao == null)
            artistsDao = createArtistsDao();
        return artistsDao;
    }

    public SongsDao getSongsDao() {
        if (songsDao == null)
            songsDao = createSongsDao();
        return songsDao;
    }

    public FavoriteDao getFavoritesDao() {
        if (favoritesDao == null)
            favoritesDao = createFavoritesDao();
        return favoritesDao;
    }
}
