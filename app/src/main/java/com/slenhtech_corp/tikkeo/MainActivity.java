package com.slenhtech_corp.tikkeo;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.slenhtech_corp.tikkeo.adapter.MainFragmentsPagerAdapter;

public class MainActivity extends NavDrawerBaseActivity implements ViewPager.OnPageChangeListener{

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if(null != viewPager){
            viewPager.setAdapter(new MainFragmentsPagerAdapter(getSupportFragmentManager(), MainActivity.this));
            viewPager.addOnPageChangeListener(this);
        }

        // Give the TabLayout to the ViewPager
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        if( null != tabLayout )
            tabLayout.setupWithViewPager(viewPager);

        setupTabIcon();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, getString(R.string.action_search), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return NAVDRAWER_HOME;
    }

    private void setupTabIcon() {
        if(null == tabLayout)
            return;
        for(int i = 0; i < MainFragmentsPagerAdapter.TAB_ICON_RES_ID.length; i++) {
//            if(Build.VERSION.SDK_INT >= 23)
                tabLayout.getTabAt(i).setIcon(setTint(MainFragmentsPagerAdapter.TAB_ICON_RES_ID[i]));
//            else
//                tabLayout.getTabAt(i).setIcon(MainFragmentsPagerAdapter.TAB_ICON_RES_ID[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setActionBarTitle(getString(MainFragmentsPagerAdapter.TAB_TITLE_RES_ID[position]));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private Drawable setTint(int iconResId) {
        ColorStateList mIconTints = ContextCompat.getColorStateList(this, R.color.tab_icon);
        Drawable icon = DrawableCompat.wrap(ContextCompat.getDrawable(this, iconResId));
        if(mIconTints != null)
            DrawableCompat.setTintList(icon, mIconTints);
        return icon;
    }
}
