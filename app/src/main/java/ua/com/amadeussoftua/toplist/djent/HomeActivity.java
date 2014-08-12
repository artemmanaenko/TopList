package ua.com.amadeussoftua.toplist.djent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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
        leftMenuFragment = (LeftMenuFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        actionBarTitle = getTitle();
        fragmentMediator = new FragmentMediator(this);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
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

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((HomeActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
