package com.slenhtech_corp.tikkeo.fragment.main.sliders;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by bface007 on 15/06/2016.
 */
public abstract class BaseSliderFragment extends Fragment{
    public static final String ARG_PAGE = "ARG_PAGE";

    protected int mPage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }
}
