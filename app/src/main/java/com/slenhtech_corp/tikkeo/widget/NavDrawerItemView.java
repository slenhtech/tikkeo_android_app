package com.slenhtech_corp.tikkeo.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.slenhtech_corp.tikkeo.R;

/**
 * Created by bface007 on 09/06/2016.
 */
public class NavDrawerItemView extends ForegroundLinearLayout {
    private ColorStateList mIconTints;

    public NavDrawerItemView(Context context) {
        super(context, null);
    }

    public NavDrawerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
        LayoutInflater.from(context).inflate(R.layout.navdrawer_item_view, this, true);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NavDrawerItemView);
        if( a.hasValue(R.styleable.NavDrawerItemView_iconTints) ) {
            mIconTints = a.getColorStateList(R.styleable.NavDrawerItemView_iconTints);
        }
    }

    public void setContent(@DrawableRes int iconResId, @StringRes int titleResId) {
        if( iconResId > 0 ) {
            Drawable icon = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), iconResId));
            if (mIconTints != null) {
                DrawableCompat.setTintList(icon, mIconTints);
            }
            ((ImageView) findViewById(R.id.icon)).setImageDrawable(icon);
        }
        ((TextView) findViewById(R.id.title)).setText(titleResId);
    }
}
