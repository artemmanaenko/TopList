package ua.com.amadeussoftua.toplist.djent;

import android.app.Application;

import ua.com.amadeussoftua.toplist.djent.db.DatabaseHelper;
import ua.com.amadeussoftua.toplist.djent.manager.NetworkManager;

public class TopListApplication extends Application {

    private NetworkManager networkManager;
    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseHelper = new DatabaseHelper(this);
    }

    public NetworkManager getNetworkManager() {
        if (networkManager == null)
            networkManager = new NetworkManager(this);
        return networkManager;
    }

    public DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }
}