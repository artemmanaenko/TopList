package ua.com.amadeussoftua.toplist.djent.manager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

import ua.com.amadeussoftua.toplist.djent.R;
import ua.com.amadeussoftua.toplist.djent.fragment.FavoritesFragment;
import ua.com.amadeussoftua.toplist.djent.fragment.HomePageFragment;
import ua.com.amadeussoftua.toplist.djent.fragment.SendPlaylistFragment;

/**
 * Created by Artem on 12.08.2014.
 */
public class FragmentMediator {

    private ActionBarActivity activity;
    private FragmentManager fragmentManager;


    public FragmentMediator(ActionBarActivity activity) {
        this.activity = activity;
    }

    private void showChapterFragment(Fragment fragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                .commit();

    }

    public void showHomeFragment() {
        showChapterFragment(new HomePageFragment());
    }

    public void showFavorites(){
        showChapterFragment(new FavoritesFragment());
    }

    public void showSendPlaylist(){
        showChapterFragment(new SendPlaylistFragment());
    }

}
