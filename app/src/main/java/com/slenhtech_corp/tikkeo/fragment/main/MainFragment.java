package com.slenhtech_corp.tikkeo.fragment.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slenhtech_corp.tikkeo.R;
import com.slenhtech_corp.tikkeo.adapter.CollectionPagerAdapter;
import com.slenhtech_corp.tikkeo.utils.Utils;
import com.viewpagerindicator.LinePageIndicator;

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
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        ViewPager collectionPager = (ViewPager) v.findViewById(R.id.curated_collection_pager);
        LinePageIndicator collectionPageIndicator = (LinePageIndicator) v.findViewById(R.id.curated_collection_pager_indicator);

        collectionPager.setClipToPadding(false);
        collectionPager.setOffscreenPageLimit(3);
        collectionPager.setPageMargin(Utils.convertDpToPixels(6));

        collectionPager.setAdapter(new CollectionPagerAdapter(getChildFragmentManager(), getActivity()));
        collectionPageIndicator.setViewPager(collectionPager);
    }
}
