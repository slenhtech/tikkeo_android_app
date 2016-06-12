package com.slenhtech_corp.tikkeo.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slenhtech_corp.tikkeo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends BaseFragment {


    public FeedFragment() {
        // Required empty public constructor
    }

    public static FeedFragment newInstance(String pageTitle) {
        FeedFragment fragment = new FeedFragment();
        Bundle args = new Bundle();
        args.putString(PAGE_TITLE_KEY, pageTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

}
