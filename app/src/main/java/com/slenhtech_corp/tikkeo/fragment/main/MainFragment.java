package com.slenhtech_corp.tikkeo.fragment.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slenhtech_corp.tikkeo.R;

public class MainFragment extends BaseFragment {

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String pageTitle) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(PAGE_TITLE_KEY, pageTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}
