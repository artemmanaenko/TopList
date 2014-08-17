package ua.com.amadeussoftua.toplist.djent.db;

import android.content.Context;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;
import java.util.concurrent.Callable;

import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.model.Playlist;

/**
 * Created by Artem on 16.08.2014.
 */
public class PlayListDao {

    private TopListApplication application;
    private RuntimeExceptionDao<Playlist, Integer> playListDao;

    public PlayListDao(Context context, RuntimeExceptionDao<Playlist, Integer> dao) {
        application = (TopListApplication) context.getApplicationContext();
        playListDao = dao;
    }

    public void setIncomingData(final List<Playlist> playLists) {
        playListDao.callBatchTasks(new Callable<Void>() {
            public Void call() throws Exception {
                insertOrUpdate(playLists);
                return null;
            }
        });
    }

    private void insertOrUpdate(final List<Playlist> playLists) {
        for (Playlist list : playLists) {
            playListDao.createOrUpdate(list);
        }
    }

}
