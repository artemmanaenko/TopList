package ua.com.amadeussoftua.toplist.djent;

import android.util.Log;

/**
 * Created by Artem on 13.08.2014.
 */
public class Debug {

    public static final boolean ENABLED = BuildConfig.DEBUG;

    public static void logD(String TAG, String msg) {
        if (ENABLED) {
            Log.d(TAG, msg);
        }
    }

    public static void logE(String TAG, String msg) {
        if (ENABLED) {
            Log.e(TAG, msg);
        }
    }

    public static void logI(String TAG, String msg) {
        if (ENABLED) {
            Log.i(TAG, msg);
        }
    }

}
