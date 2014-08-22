package ua.com.amadeussoftua.toplist.djent.fragment;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import de.greenrobot.event.EventBus;
import ua.com.amadeussoftua.toplist.djent.Debug;
import ua.com.amadeussoftua.toplist.djent.R;
import ua.com.amadeussoftua.toplist.djent.adapter.SimplePlaylistGridAdapter;
import ua.com.amadeussoftua.toplist.djent.events.BusEventPlaylistsLoaded;
import ua.com.amadeussoftua.toplist.djent.loaders.SearchPlaylistAsynkTask;

/**
 * Created by Artem on 17.08.2014.
 */
public class SearchPlayListFragment extends BaseFragment implements SearchView.OnQueryTextListener {

    public static final String KEY_SEARCH_QUERY = "key_search_query";

    private final String TAG = "SearchPlayListFragment";

    private SearchView searchView;

    private String currentSearchQuery;

    private SimplePlaylistGridAdapter adapter;
    private GridView gridView;
    private String lastQuery;

    private SimplePlaylistGridAdapter getAdapter() {
        adapter = new SimplePlaylistGridAdapter(getActivity());
        return adapter;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.home, menu);
        initSearchView(menu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_grid, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_SEARCH_QUERY))
            currentSearchQuery = savedInstanceState.getString(KEY_SEARCH_QUERY);
        else
            currentSearchQuery = getArguments().getString(KEY_SEARCH_QUERY);

        initUI();
        searchView.setQuery(currentSearchQuery, true);
    }

    private void initUI(){
        gridView = (GridView) getView().findViewById(R.id.grid);
        gridView.setAdapter(getAdapter());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_SEARCH_QUERY, currentSearchQuery);
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
        if (searchQuery.equals(lastQuery))
            return true;
        Debug.logD(TAG, "Search query is: " + searchQuery);
        currentSearchQuery = searchQuery;
        new SearchPlaylistAsynkTask(getActivity()).execute(currentSearchQuery);
        lastQuery = currentSearchQuery;
        return true;
    }

    public void onEvent(BusEventPlaylistsLoaded event) {
        if (event.getPlaylists().isEmpty()) {
            setNoMatchesState();
        }
        adapter.setPlayLists(event.getPlaylists());
    }

    private void setNoMatchesState() {
        lastQuery = "";
        //TODO
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
