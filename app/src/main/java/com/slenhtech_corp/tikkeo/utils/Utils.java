package com.slenhtech_corp.tikkeo.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by bface007 on 15/06/2016.
 */
public class Utils {

    public static int convertDpToPixels(int dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        int px = dp * (metrics.densityDpi / 160);
        return px;
    }
}
