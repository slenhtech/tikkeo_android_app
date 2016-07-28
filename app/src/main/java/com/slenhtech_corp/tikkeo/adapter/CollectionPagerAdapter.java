package com.slenhtech_corp.tikkeo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.slenhtech_corp.tikkeo.fragment.main.sliders.CollectionPageFragment;

/**
 * Created by bface007 on 15/06/2016.
 */
public class CollectionPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CollectionPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return CollectionPageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return CollectionPageFragment.COLLECTION_IMAGE_RES_ID.length;
    }
}
