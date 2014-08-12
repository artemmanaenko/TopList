package ua.com.amadeussoftua.toplist.djent.fragment;

import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;

import ua.com.amadeussoftua.toplist.djent.adapter.HomePageAdapter;

/**
 * Created by Artem on 12.08.2014.
 */
public class HomePageFragment extends ListFragment {

    @Override
    public void setListAdapter(ListAdapter adapter) {
        //TODO getListView().addHeaderView(createHeaderView());
        super.setListAdapter(new HomePageAdapter(getActivity()));
    }

    private View createHeaderView() {
        return new View(getActivity());
    }

}
