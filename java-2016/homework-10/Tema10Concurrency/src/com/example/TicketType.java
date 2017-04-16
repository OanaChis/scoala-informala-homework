package com.example;

/**
 * Created by Oana on 3/6/2017.
 */

import java.util.Random;

/**
 * this is enum class as requested , we have 5 types of passes
 */
public enum TicketType {
    FULL("FULL"),
    FULLVIP("FULLVIP"),
    FREEPASS("FREEPASS"),
    ONEDAY("ONEDAY"),
    ONEDAYVIP("ONEDAYVIP");

    private String ticketType;

    TicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketType() {
        return ticketType;
    }

    /**
     * this method will return a random ticket type for attendee
     */
    public static TicketType randomTicketType() {
        Random myRandom = new Random();
        return values()[myRandom.nextInt(values().length)];
    }
}