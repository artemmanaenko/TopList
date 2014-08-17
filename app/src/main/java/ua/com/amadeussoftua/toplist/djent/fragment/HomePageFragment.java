package ua.com.amadeussoftua.toplist.djent.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;

import ua.com.amadeussoftua.toplist.djent.TopListApplication;
import ua.com.amadeussoftua.toplist.djent.adapter.HomePageAdapter;

/**
 * Created by Artem on 12.08.2014.
 */
public class HomePageFragment extends ListFragment {

    private TopListApplication application;

    private TopListApplication getApplication() {
        if (application == null) {
            application = (TopListApplication) getActivity().getApplication();
        }
        return application;
    }

    @Override
    public void setListAdapter(ListAdapter adapter) {
        //TODO getListView().addHeaderView(createHeaderView());
        super.setListAdapter(new HomePageAdapter(getActivity()));
    }

    private View createHeaderView() {
        return new View(getActivity());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
    }

    private void initUI() {
        getApplication().getNetworkManager().requestAllPlayLists();
        getApplication().getNetworkManager().requestAllArtists();
        getApplication().getNetworkManager().requestAllSongs();
    }

}
