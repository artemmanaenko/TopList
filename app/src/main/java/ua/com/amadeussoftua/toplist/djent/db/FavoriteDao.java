package ua.com.amadeussoftua.toplist.djent.db;

import android.content.Context;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.model.FavoriteItem;

/**
 * Created by Artem on 16.08.2014.
 */
public class FavoriteDao {

    private TopListApplication application;
    private RuntimeExceptionDao<FavoriteItem, Integer> favoriteDao;

    private List<Integer> favoritesList = new ArrayList<Integer>();

    public FavoriteDao(Context context, RuntimeExceptionDao<FavoriteItem, Integer> dao) {
        application = (TopListApplication) context.getApplicationContext();
        favoriteDao = dao;
        refreshFavoritesList();
    }

    private void insertOrUpdate(final List<FavoriteItem> playLists) {
        for (FavoriteItem list : playLists) {
            favoriteDao.createOrUpdate(list);
        }
    }

    private void refreshFavoritesList() {
        favoritesList.clear();
        List<FavoriteItem> favorites = favoriteDao.queryForAll();
        for (FavoriteItem item : favorites) {
            favoritesList.add(item.getId());
        }
    }

    public boolean isFavorite(int playlistId) {
        return favoritesList.contains(playlistId);
    }

}
