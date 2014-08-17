package ua.com.amadeussoftua.toplist.djent.db;

import android.content.Context;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;
import java.util.concurrent.Callable;

import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.model.Song;

/**
 * Created by Artem on 16.08.2014.
 */
public class SongsDao {

    private TopListApplication application;
    private RuntimeExceptionDao<Song, Integer> songsDao;

    public SongsDao(Context context, RuntimeExceptionDao<Song, Integer> dao) {
        application = (TopListApplication) context.getApplicationContext();
        songsDao = dao;
    }

    public void setIncomingData(final List<Song> Songs) {
        songsDao.callBatchTasks(new Callable<Void>() {
            public Void call() throws Exception {
                insertOrUpdate(Songs);
                return null;
            }
        });
    }

    private void insertOrUpdate(final List<Song> Songs) {
        for (Song list : Songs) {
            songsDao.createOrUpdate(list);
        }
    }

}
