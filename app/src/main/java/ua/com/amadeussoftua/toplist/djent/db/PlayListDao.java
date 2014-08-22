package ua.com.amadeussoftua.toplist.djent.db;

import android.content.Context;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Collections;
import java.util.List;

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
        DatabaseConnection conn = playListDao.startThreadConnection();
        Savepoint savePoint = null;
        try {
            savePoint = conn.setSavePoint(null);
            insertOrUpdate(playLists);
            conn.commit(savePoint);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            playListDao.endThreadConnection(conn);
        }
    }

    private void insertOrUpdate(final List<Playlist> playLists) {
        for (Playlist list : playLists) {
            playListDao.createOrUpdate(list);
        }
    }

    public QueryBuilder<Playlist, Integer> getQueryBuilder() {
        return playListDao.queryBuilder();
    }

    public List<Playlist> requestSearchWithSort(String searchQuery) {
        QueryBuilder<Playlist, Integer> query = playListDao.queryBuilder();
        try {
            query.where().like(Playlist.COLUMN_NAME_EN, "%" + searchQuery + "%");
            return playListDao.query(query.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Playlist> requestAllPlayLists() {
        return playListDao.queryForAll();
    }

}
