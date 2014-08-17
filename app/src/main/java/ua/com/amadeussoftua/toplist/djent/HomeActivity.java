package ua.com.amadeussoftua.toplist.djent;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.backendless.Backendless;

import ua.com.amadeussoftua.toplist.djent.fragment.LeftMenuFragment;
import ua.com.amadeussoftua.toplist.djent.manager.FragmentMediator;


public class HomeActivity extends ActionBarActivity implements LeftMenuFragment.NavigationDrawerCallbacks {

    private LeftMenuFragment leftMenuFragment;
    private CharSequence actionBarTitle;
    private FragmentMediator fragmentMediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(getBaseContext(), Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);

        leftMenuFragment = (LeftMenuFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        actionBarTitle = getTitle();
        fragmentMediator = new FragmentMediator(this);
        fragmentMediator.showHomeFragment();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 1:
                fragmentMediator.showHomeFragment();
                actionBarTitle = getString(R.string.left_menu_home);
                break;
            case 2:
                fragmentMediator.showFavorites();
                actionBarTitle = getString(R.string.left_menu_favorites);
                break;
            case 3:
                fragmentMediator.showSendPlaylist();
                actionBarTitle = getString(R.string.left_menu_send_your_list);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(actionBarTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!leftMenuFragment.isDrawerOpen()) {
            getMenuInflater().inflate(R.menu.home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
