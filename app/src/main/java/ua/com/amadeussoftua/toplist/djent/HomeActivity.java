package ua.com.amadeussoftua.toplist.djent;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.backendless.Backendless;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import ua.com.amadeussoftua.toplist.djent.fragment.LeftMenuFragment;
import ua.com.amadeussoftua.toplist.djent.manager.FragmentMediator;


public class HomeActivity extends ActionBarActivity implements LeftMenuFragment.NavigationDrawerCallbacks, SearchView.OnQueryTextListener {

    private final static String TAG = "HomeActivity";

    private LeftMenuFragment leftMenuFragment;
    private CharSequence actionBarTitle;
    private FragmentMediator fragmentMediator;
    private TopListApplication application;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        application = (TopListApplication) getApplication();

        if (!application.getDatabaseHelper().isOpen())
            application.createDatabaseHelper();

        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(getBaseContext(), Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);

        leftMenuFragment = (LeftMenuFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        actionBarTitle = getTitle();
        fragmentMediator = new FragmentMediator(this);
        fragmentMediator.showHomeFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OpenHelperManager.releaseHelper();
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
            initSearchView(menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void initSearchView(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getString(android.R.string.search_go));
        searchView.setOnQueryTextListener(this);
    }

    public boolean onQueryTextChange(String searchQuery) {
        return true;
    }

    public boolean onQueryTextSubmit(String searchQuery) {
        Debug.logD(TAG, "Search query is: " + searchQuery);
        searchView.clearFocus(); //avoid duplicated calls of submit. Known system issue.
        fragmentMediator.showSearchPlayList(searchQuery);
        return true;
    }

}
