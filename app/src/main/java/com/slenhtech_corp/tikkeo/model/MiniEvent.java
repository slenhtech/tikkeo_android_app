package com.slenhtech_corp.tikkeo.model;

import java.util.ArrayList;

/**
 * Created by bface007 on 26/06/2016.
 */
public class MiniEvent {
    private Event parent;
    private String miniEventTitle;
    private String miniEventDate;
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public MiniEvent(String title, String date) {
        this.miniEventTitle = title;
        this.miniEventDate = date;
    }

    public Event getParent() {
        return this.parent;
    }

    public void setParent(Event event) {
        this.parent = event;
    }

    public String getMiniEventTitle() {
        return this.miniEventTitle;
    }

    public String getMiniEventDate() {
        return this.miniEventDate;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        ticket.setFrom(this);
        update();
    }

    public void removeTicket(int index) {
        this.tickets.remove(index);
        update();
    }

    public ArrayList<Ticket> getAllTickets() {
        return this.tickets;
    }

    public Ticket getOneTicket(int index) {
        return this.tickets.get(index);
    }

    public int getTicketsCount() {
        return this.tickets.size();
    }

    private void update() {

        if(null != this.getParent()) {
            int i = 0;
            for(Ticket ticket : this.getAllTickets()) {
                if (ticket.getPrice() > 0) {
                    this.getParent().setHasPaidTicket(true);
                    break;
                }else
                    i++;
            }
            if(i == this.getAllTickets().size()) {
                this.getParent().setHasPaidTicket(false);
            }
        }
    }
}
