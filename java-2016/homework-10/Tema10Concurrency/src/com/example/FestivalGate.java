package com.example;

/**
 * Created by Oana on 3/6/2017.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the FestivalGate class
 */
public class FestivalGate {

    private int full;
    private int freePass;
    private int fullVip;
    private int oneDayPass;
    private int oneDayVip;
    private int attendeeNumber;

    /**
     * this is que in here we will store ticket type passes
     */


    private Queue<TicketType> theLine = new LinkedList<>();

    /**
     * this is the method that will count tickets based on ticket type
     */


    public void countTicketsTypes() {
        resetNumbers();
        for (TicketType ticket : theLine) {
            if (ticket.getTicketType().equals("FULL")) {
                full++;
            }
            if (ticket.getTicketType().equals("FREEPASS")) {
                freePass++;
            }
            if (ticket.getTicketType().equals("FULLVIP")) {
                fullVip++;
            }
            if (ticket.getTicketType().equals("ONEDAY")) {
                oneDayPass++;
            }
            if (ticket.getTicketType().equals("ONEDAYVIP")) {
                oneDayVip++;
            }

        }
    }


    /**
     * this method will add all the tickets from all attendees and all the tickets will be placed in a que
     */
    public void addTicketInQueue(TicketType ticketType) {
        theLine.add(ticketType);
    }


    /**
     * This method will count tickets on the gate
     */
    public void countTicketsOnGate() {
        countTicketsTypes();

        System.out.println("\n" + getAttendeeNumber() + " attendee entered " + '\n' + getFull() + " with FULL ticket type " + '\n' + getFreePass() + " with FREEPASS ticket type " + '\n' + getFullVip() + " with FULLVIP ticket type " + '\n' + getOneDay() + " with ONEDAY ticket type " + '\n' + getOneDayVip() + " with ONEDAYVIP ticket type " + '\n');

    }


    /**
     * This method will reset our count to 0
     */
    public void resetNumbers() {
        full = 0;
        freePass = 0;
        fullVip = 0;
        oneDayPass = 0;
        oneDayVip = 0;
    }


    public Queue<TicketType> getTheLine() {
        return theLine;
    }


    public int getFull() {
        return full;
    }


    public int getFreePass() {
        return freePass;
    }


    public int getFullVip() {
        return fullVip;
    }


    public int getOneDay() {
        return oneDayPass;
    }


    public int getOneDayVip() {
        return oneDayVip;
    }


    /**
     * this method will count the attendee based on number of tickets that are stored in a que
     *
     * @return
     */

    public int getAttendeeNumber() {
        attendeeNumber = theLine.size();
        return attendeeNumber;
    }


}
