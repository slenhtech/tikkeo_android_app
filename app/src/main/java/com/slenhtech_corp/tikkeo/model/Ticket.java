package com.slenhtech_corp.tikkeo.model;

import android.graphics.drawable.Drawable;

/**
 * Created by bface007 on 26/06/2016.
 */
public class Ticket {

    private Drawable qrCode;
    private MiniEvent from;
    private int price = 0;

    public Ticket(Drawable qrCode) {
        this.qrCode = qrCode;
    }

    public Ticket(Drawable qrCode, int price) {
        this.qrCode = qrCode;
        this.price = price;
    }

    public Drawable getQrCode() {
        return this.qrCode;
    }

    public void setFrom(MiniEvent miniEvent) {
        this.from = miniEvent;
    }

    public MiniEvent getFrom() {
        return this.from;
    }

    public int getPrice() {
        return this.price;
    }
}
