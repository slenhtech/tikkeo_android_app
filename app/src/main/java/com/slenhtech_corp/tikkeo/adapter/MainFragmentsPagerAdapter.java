package com.slenhtech_corp.tikkeo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.slenhtech_corp.tikkeo.R;
import com.slenhtech_corp.tikkeo.fragment.main.FeedFragment;
import com.slenhtech_corp.tikkeo.fragment.main.MainFragment;
import com.slenhtech_corp.tikkeo.fragment.main.RecommandedFragment;

/**
 * Created by bface007 on 11/06/2016.
 */
public class MainFragmentsPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public static final int[] TAB_TITLE_RES_ID = new int[]{
            R.string.app_name,
            R.string.fragment_feed,
            R.string.fragment_recommanded
    };

    public static final int[] TAB_ICON_RES_ID = new int[]{
            R.drawable.tab_icon_home,
            R.drawable.tab_icon_clock,
            R.drawable.tab_icon_star
    };

    public MainFragmentsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        String title = null;
        title = this.mContext.getString(TAB_TITLE_RES_ID[position]);
        switch (position) {
            case 0:
                fragment = MainFragment.newInstance(title);
                break;
            case 1:
                fragment = FeedFragment.newInstance(title);
                break;
            case 2:
                fragment = RecommandedFragment.newInstance(title);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return TAB_TITLE_RES_ID.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return this.mContext.getString(TAB_TITLE_RES_ID[position]);
        return null;
    }
}
