package ua.com.amadeussoftua.toplist.djent.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Artem on 17.08.2014.
 */
@DatabaseTable(tableName = "favorites")
public class FavoriteItem {

    @DatabaseField(id = true)
    private int id;

    public int getId() {
        return id;
    }
}
