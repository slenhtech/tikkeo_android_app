package com.slenhtech_corp.tikkeo.model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bface007 on 26/06/2016.
 */
public class Event {

    private ArrayList<MiniEvent> miniEvents = new ArrayList<MiniEvent>();
    private String eventName;
    private boolean hasPaidTicket = false;
    private Date eventMinDate;
    private Date eventMaxDate;
    private String eventCategory;
    private Drawable eventCover;
    private String eventDescription;
    private Author eventAuthor;
    private String eventAddress;

    public Event(String name, String address, Author author) {
        this.eventName = name;
        this.eventAuthor = author;
        this.eventAddress = address;
    }

    public Event(String name, String desc, String category, String address, Drawable cover, Author author) {
        this.eventName = name;
        this.eventDescription = desc;
        this.eventCategory = category;
        this.eventCover = cover;
        this.eventAuthor = author;
        this.eventAddress = address;
    }

    public void addMiniEvent(MiniEvent miniEvent) {
        this.miniEvents.add(miniEvent);
        miniEvent.setParent(this);
        updateDates();
    }

    public void removeMiniEvent(int index) {
        this.miniEvents.remove(index);
        updateDates();
    }

    public ArrayList<MiniEvent> getAllMiniEvents() {
        return this.miniEvents;
    }

    public MiniEvent getOneMiniEvent(int index) {
        return this.miniEvents.get(index);
    }

    public void setEventName(String name) {
        this.eventName = name;
    }

    public String getEventName() {
        return this.eventName;
    }

    public boolean hasPaidTicket() {
        return this.hasPaidTicket;
    }

    public void setHasPaidTicket(boolean has) {
        this.hasPaidTicket = has;
    }

    public void setEventDescription(String description) {
        this.eventDescription = description;
    }

    public String getEventDescription() {
        return this.eventDescription;
    }

    public void setEventCategory(String category) {
        this.eventCategory = category;
    }

    public String getEventCategory() {
        return this.eventCategory;
    }

    public void setEventAuthor(Author author) {
        this.eventAuthor = author;
    }

    public Author getEventAuthor() {
        return this.eventAuthor;
    }

    public Date getEventMinDate() {
        return this.eventMinDate;
    }

    public Date getEventMaxDate() {
        return this.eventMaxDate;
    }

    public void setEventCover(Drawable cover) {
        this.eventCover = cover;
    }

    public Drawable getEventCover() {
        return this.eventCover;
    }

    public void setEventAddress(String address) {
        this.eventAddress = address;
    }

    public String getEventAddress() {
        return this.eventAddress;
    }

    private void updateDates() {

    }
}
