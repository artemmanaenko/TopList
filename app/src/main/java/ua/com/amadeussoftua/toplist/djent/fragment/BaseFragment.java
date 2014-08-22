package ua.com.amadeussoftua.toplist.djent.fragment;

import android.support.v4.app.Fragment;

import ua.com.amadeussoftua.toplist.djent.TopListApplication;

/**
 * Created by Artem on 17.08.2014.
 */
public class BaseFragment extends Fragment {

    private TopListApplication application;

    protected TopListApplication getApplication() {
        if (application == null) {
            if (getActivity() != null)
                application = (TopListApplication) getActivity().getApplication();
        }
        return application;
    }
}
