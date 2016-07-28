package com.slenhtech_corp.tikkeo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.slenhtech_corp.tikkeo.model.Author;
import com.slenhtech_corp.tikkeo.model.Event;
import com.slenhtech_corp.tikkeo.model.MiniEvent;
import com.slenhtech_corp.tikkeo.model.Ticket;

/**
 * Created by bface007 on 26/06/2016.
 */
public class MyTicketsActivity extends NavDrawerBaseActivity {

    private Event[] events;
    public final static String EXTRA = "tikkeo.detail.ticket";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytickets);
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return NAVDRAWER_MY_TICKETS;
    }

    private Event[] createDummyData() {
        // 1
        Author author = new Author("John Doe", "johndoe");
        Event event1 = new Event("CAN Gabon 2017", "Libreville", author);
        MiniEvent miniEvent1 = new MiniEvent("Gabon VS Cote d'Ivoire", "02/02/2017");
        event1.addMiniEvent(miniEvent1);
        Drawable qrCode1;
        Drawable qrCode2;
        if(Build.VERSION.SDK_INT >= 21){
            qrCode1 = getDrawable(R.drawable.qr_code_1);
            qrCode2 = getDrawable(R.drawable.qr_code_2);
        }
        else {
            qrCode1 = getResources().getDrawable(R.drawable.qr_code_1);
            qrCode2 = getResources().getDrawable(R.drawable.qr_code_2);
        }
        Ticket ticket1 = new Ticket(qrCode1, 5000);
        Ticket ticket2 = new Ticket(qrCode2, 13000);
        miniEvent1.addTicket(ticket1);
        miniEvent1.addTicket(ticket2);

        return new Event[]{
                event1
        };
    }

    public void openTicket(View v) {
        Intent intent = new Intent(this, TicketsDetailActivity.class);
        switch (v.getId()) {
            case R.id.event_1:
                intent.putExtra(EXTRA, "can");
                break;
            case R.id.event_2:
                intent.putExtra(EXTRA, "gpe");
                break;
        }
        startActivity(intent);
    }
}
