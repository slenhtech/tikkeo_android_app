package com.slenhtech_corp.tikkeo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.slenhtech_corp.tikkeo.fragment.ticket.TicketFragment;

/**
 * Created by bface007 on 26/06/2016.
 */
public class TicketPagerAdapter extends FragmentPagerAdapter {
    private String m;

    public TicketPagerAdapter(FragmentManager fm, String m) {
        super(fm);
        this.m = m;
    }

    @Override
    public Fragment getItem(int position) {
        return TicketFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        if(m.equals("can"))
            return 3;
        else
            return 1;
    }
}
