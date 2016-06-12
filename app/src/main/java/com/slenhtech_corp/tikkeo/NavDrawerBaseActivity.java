package com.slenhtech_corp.tikkeo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.slenhtech_corp.tikkeo.widget.NavDrawerItemView;

import java.util.ArrayList;

/**
 * Created by bface007 on 08/06/2016.
 */
public abstract class NavDrawerBaseActivity extends AppCompatActivity {

    private static final String LOG = NavDrawerBaseActivity.class.getSimpleName();
    private DrawerLayout mDrawerLayout;

    protected static final int NAVDRAWER_HOME = 0;
    protected static final int NAVDRAWER_MY_TICKETS = 1;
    protected static final int NAVDRAWER_MY_FAVORITES = 2;
    protected static final int NAVDRAWER_NOTIFICATIONS = 3;
    protected static final int NAVDRAWER_SETTINGS = 4;
    protected static final int NAVDRAWER_SHARE = 5;
    protected static final int NAVDRAWER_ABOUT = 6;
    protected static final int NAVDRAWER_ITEM_INVALID = -1;
    protected static final int NAVDRAWER_SEPARATOR = -2;

    protected static final boolean HAS_ACTIONBAR = true;

    private static final int[] NAVDRAWER_TITLE_RES_ID = new int[]{
            R.string.menu_home,
            R.string.menu_my_tickets,
            R.string.menu_my_favorites,
            R.string.menu_notifications,
            R.string.menu_settings,
            R.string.menu_share,
            R.string.menu_about
    };

    private static final int[] NAVDRAWER_ICON_RES_ID = new int[] {
            R.drawable.basic_home,
            R.drawable.ecommerce_ticket,
            R.drawable.basic_heart,
            R.drawable.music_bell,
            R.drawable.basic_gear,
            0,
            0
    };

    // delay to launch nav drawer item, to allow close animation to play
    private static final int NAVDRAWER_LAUNCH_DELAY = 250;

    // fade in and fade out durations for the main content when switching between
    // different Activities of the app through the Nav Drawer
    private static final int MAIN_CONTENT_FADEOUT_DURATION = 150;

    private static final int MAIN_CONTENT_FADEIN_DURATION = 250;

    // list of navdrawer items that were actually added to the navdrawer, in order
    private ArrayList<Integer> mNavDrawerItems = new ArrayList<Integer>();

    // views that correspond to each navdrawer item, null if not yet created
    private View[] mNavDrawerItemViews = null;

    // Primary toolbar and drawer toggle
    private Toolbar mActionBarToolbar;

    private ViewGroup mDrawerItemsListContainer;

    private ActionBar mActionBar;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler = new Handler();

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.navdrawer_base_activity);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.base_frame);
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
        setupActionbar();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setupNavDrawer();
    }

    protected boolean hasActionBar() {
        return HAS_ACTIONBAR;
    }

    /**
     *
     */
    private void setupActionbar() {
        if( mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        }

        if( null != mActionBarToolbar ) {
            setSupportActionBar(mActionBarToolbar);
            mActionBar = getSupportActionBar();
            if( null != mActionBar ) {
                mActionBar.setHomeAsUpIndicator(R.drawable.ic_home);
                mActionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    /**
     * Returns the navigation drawer item that corresponds to this Activity. Subclasses
     * of NavDrawerBaseActivity override this to indicate what nav drawer item corresponds to them
     * Return NAVDRAWER_ITEM_INVALID to mean that this Activity should not have a Nav Drawer.
     */
    protected int getSelfNavDrawerItem() {
        return NAVDRAWER_ITEM_INVALID;
    }

    /**
     * Sets up the navigation drawer as appropriate. Note that the nav drawer will be
     * different depending on whether the attendee indicated that they are attending the
     * event on-site vs. attending remotely.
     */
    private void setupNavDrawer() {
        int selfItem = getSelfNavDrawerItem();
        final AppCompatActivity _self = (AppCompatActivity) this;

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        if( null == mDrawerLayout )
            return;

        if( null != mActionBarToolbar ) {
            mActionBarToolbar.setNavigationIcon(R.drawable.ic_home);
            mActionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                mActionBarToolbar.setAlpha(1 - slideOffset / 2);
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

//        final ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
//                _self, mDrawerLayout, mActionBarToolbar, R.string.drawer_open, R.string.drawer_close
//        ) {
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//
//
//            }
//
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                super.onDrawerSlide(drawerView, slideOffset);
//                mActionBarToolbar.setAlpha(1 - slideOffset / 2);
//            }
//        };

//        mDrawerLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                mDrawerToggle.syncState();
//            }
//        });

        populateNavDrawer();
    }

    /**
     * Defines the Navigation Drawer items to display by updating {@code mNavDrawerItems} then
     * forces the Navigation Drawer to redraw itself.
     */
    private void populateNavDrawer() {
        mNavDrawerItems.clear();

        mNavDrawerItems.add(NAVDRAWER_HOME);
        mNavDrawerItems.add(NAVDRAWER_MY_TICKETS);
        mNavDrawerItems.add(NAVDRAWER_MY_FAVORITES);
        mNavDrawerItems.add(NAVDRAWER_NOTIFICATIONS);
        mNavDrawerItems.add(NAVDRAWER_SETTINGS);
        mNavDrawerItems.add(NAVDRAWER_SEPARATOR);
        mNavDrawerItems.add(NAVDRAWER_SHARE);
        mNavDrawerItems.add(NAVDRAWER_ABOUT);

        createNavDrawerItems();
    }

    private void createNavDrawerItems() {
        mDrawerItemsListContainer = (ViewGroup) findViewById(R.id.navdrawer_items_list);
        if( null == mDrawerItemsListContainer )
            return;

        mNavDrawerItemViews = new View[mNavDrawerItems.size()];
        mDrawerItemsListContainer.removeAllViews();
        int i = 0;
        for(int itemId : mNavDrawerItems) {
            mNavDrawerItemViews[i] = makeNavDrawerItem(itemId, mDrawerItemsListContainer);
            mDrawerItemsListContainer.addView(mNavDrawerItemViews[i]);
            i++;
        }
    }

    private View makeNavDrawerItem(final int itemId, ViewGroup container) {
        if( isSeparator(itemId) ) {
            View separator = getLayoutInflater().inflate(R.layout.navdrawer_separator, container, false);
            return  separator;
        }

        ViewGroup item;
        if( 0 == NAVDRAWER_ICON_RES_ID[itemId] ){
            item = (LinearLayout) getLayoutInflater().inflate(R.layout.navdrawer_item_simple, container, false);
            ((TextView) item.findViewById(R.id.title)).setText(NAVDRAWER_TITLE_RES_ID[itemId]);
        }else {
            item = (NavDrawerItemView) getLayoutInflater().inflate(R.layout.navdrawer_item, container, false);
            ((NavDrawerItemView) item).setContent(NAVDRAWER_ICON_RES_ID[itemId], NAVDRAWER_TITLE_RES_ID[itemId]);
        }

        item.setActivated(getSelfNavDrawerItem() == itemId);
        if( item.isActivated() )
            item.setContentDescription(getString(R.string.navdrawer_selected_menu_item_a11y_wrapper, getString(NAVDRAWER_TITLE_RES_ID[itemId])));
        else
            item.setContentDescription(getString(R.string.navdrawer_menu_item_a11y_wrapper, getString(NAVDRAWER_TITLE_RES_ID[itemId])));

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onNavDrawerItemClicked(itemId);
                Toast.makeText(NavDrawerBaseActivity.this, "t", Toast.LENGTH_LONG).show();
            }
        });
        return item;
    }

    private boolean isSeparator(int itemId) {
        return itemId == NAVDRAWER_SEPARATOR;
    }

    private void onNavDrawerItemClicked(final int itemId) {
        if( itemId == getSelfNavDrawerItem() ) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return;
        }

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToNavDrawerItem(itemId);
            }
        }, NAVDRAWER_LAUNCH_DELAY);

        // change the active item on the list so the user can see the item changed
        setSelectedNavDrawerItem(itemId);
        // fade out the main content
        View mainContent = findViewById(R.id.main_content);
        if( null != mainContent )
            mainContent.animate().alpha(0).setDuration(MAIN_CONTENT_FADEOUT_DURATION);

        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private void setSelectedNavDrawerItem(int itemId) {
        if( mNavDrawerItems != null ) {
            for(int i = 0; i < mNavDrawerItemViews.length; i++) {
                if( i < mNavDrawerItems.size() ) {
                    int thisItemId = mNavDrawerItems.get(i);
                    mNavDrawerItemViews[i].setActivated(itemId == thisItemId);
                }
            }
        }
    }

    private void goToNavDrawerItem(int item) {
        switch (item) {
            case NAVDRAWER_HOME:

                break;
            case NAVDRAWER_MY_TICKETS:

                break;
            case NAVDRAWER_MY_FAVORITES:

                break;
            case NAVDRAWER_NOTIFICATIONS:

                break;
            case NAVDRAWER_SETTINGS:

                break;
            case NAVDRAWER_SHARE:

                break;
            case NAVDRAWER_ABOUT:

                break;
        }
        Toast.makeText(this, getString(NAVDRAWER_TITLE_RES_ID[item]), Toast.LENGTH_LONG).show();
    }

    /**
     * Enables back navigation for activities that are launched from the NavBar. See
     * {@code AndroidManifest.xml} to find out the parent activity names for each activity.
     * @param intent
     */
    private void createBackStack(Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            TaskStackBuilder builder = TaskStackBuilder.create(this);
            builder.addNextIntentWithParentStack(intent);
            builder.startActivities();
        } else {
            startActivity(intent);
            finish();
        }
    }

    public void setActionBarTitle(String title) {
        if( getSupportActionBar() != null )
            getSupportActionBar().setTitle(title);
    }
}
