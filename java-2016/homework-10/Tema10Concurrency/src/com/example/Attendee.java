package com.example;

/**
 * Created by Oana on 3/6/2017.
 */

/**
 * This is the Attendee class
 * every attendee has a random ticketType
 */
public class Attendee {
    public TicketType ticketType;
    //  private FestivalGate gate;

    public Attendee() {
        this.ticketType = TicketType.randomTicketType();
        // this.gate = gate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

//    public void setTicketType(TicketType ticketType) {
//        this.ticketType = ticketType;
//    }

//    public FestivalGate getGate() {
//        return gate;
//    }
//
//    public void setGate(FestivalGate gate) {
//        this.gate = gate;
//    }
}
