package scode.nb.downimage;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by neobyte on 24/10/17.
 */

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }

}
