package ua.com.amadeussoftua.toplist.djent;

import android.content.Context;

import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;

public class DefaultCallback<T> extends BackendlessCallback<T> {

    private Context context;

    public DefaultCallback(Context context) {
        this.context = context;
    }

    @Override
    public void handleResponse(T response) {

    }

    @Override
    public void handleFault(BackendlessFault fault) {

    }
}