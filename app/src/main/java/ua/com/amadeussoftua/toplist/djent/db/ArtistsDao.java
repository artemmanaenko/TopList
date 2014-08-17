package ua.com.amadeussoftua.toplist.djent.db;

import android.content.Context;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;
import java.util.concurrent.Callable;

import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.model.Artist;

/**
 * Created by Artem on 16.08.2014.
 */
public class ArtistsDao {

    private TopListApplication application;
    private RuntimeExceptionDao<Artist, Integer> artistDao;

    public ArtistsDao(Context context, RuntimeExceptionDao<Artist, Integer> dao) {
        application = (TopListApplication) context.getApplicationContext();
        artistDao = dao;
    }

    public void setIncomingData(final List<Artist> Artists) {
        artistDao.callBatchTasks(new Callable<Void>() {
            public Void call() throws Exception {
                insertOrUpdate(Artists);
                return null;
            }
        });
    }

    private void insertOrUpdate(final List<Artist> Artists) {
        for (Artist list : Artists) {
            artistDao.createOrUpdate(list);
        }
    }

}
