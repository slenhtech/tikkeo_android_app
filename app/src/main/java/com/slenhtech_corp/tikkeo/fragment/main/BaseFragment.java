package com.slenhtech_corp.tikkeo.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by bface007 on 11/06/2016.
 */
public class BaseFragment extends Fragment {
    protected String mPageTitle;
    public static final String PAGE_TITLE_KEY = "com.slenhtech_corp.tikkeo.PAGE_TITLE";

    public BaseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
