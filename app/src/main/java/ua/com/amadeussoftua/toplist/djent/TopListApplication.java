package ua.com.amadeussoftua.toplist.djent;

import android.app.Application;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import ua.com.amadeussoftua.toplist.djent.db.DatabaseHelper;
import ua.com.amadeussoftua.toplist.djent.manager.NetworkManager;

public class TopListApplication extends Application {

    private NetworkManager networkManager;
    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        createDatabaseHelper();
    }

    public NetworkManager getNetworkManager() {
        if (networkManager == null)
            networkManager = new NetworkManager(this);
        return networkManager;
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }

    public void createDatabaseHelper() {
        databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
    }

}