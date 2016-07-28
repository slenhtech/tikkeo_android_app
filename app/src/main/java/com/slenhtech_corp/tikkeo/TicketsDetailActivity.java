package com.slenhtech_corp.tikkeo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.slenhtech_corp.tikkeo.adapter.TicketPagerAdapter;
import com.viewpagerindicator.LinePageIndicator;

public class TicketsDetailActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_detail);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyTicketsActivity.EXTRA);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(setTitle(message));

        viewPager = (ViewPager) findViewById(R.id.ticket_pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setClipToPadding(false);

        viewPager.setAdapter(new TicketPagerAdapter(getSupportFragmentManager(), message));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ticket_detail_menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        LinePageIndicator pageIndicator = (LinePageIndicator) findViewById(R.id.ticket_pager_indicator);
        pageIndicator.setViewPager(viewPager);
        super.onResume();
    }

    private String setTitle(String m) {
        switch (m) {
            case "gpe":
                return "Final du Grand Prix de l'Excellence - Edition 2017";
            case "can":
                return "CAN Gabon 2017 - Phase finale";
            default:
                return "";
        }
    }

}
