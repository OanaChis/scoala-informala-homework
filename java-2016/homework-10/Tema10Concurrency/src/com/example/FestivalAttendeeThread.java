package com.example;

/**
 * Created by Oana on 3/6/2017.
 * this is a thread that represents a festival attendee
 */

public class FestivalAttendeeThread extends Thread {

    private FestivalGate festivalFestivalGate;
    private Attendee attendee = new Attendee();
    private int positionInQue;
    private int attendeesNumber = 100;

    public FestivalAttendeeThread(FestivalGate festivalFestivalGate) {
        this.festivalFestivalGate = festivalFestivalGate;
    }

    @Override
    public void run() {
        synchronized (festivalFestivalGate) {

            for (int i = 1; i <= attendeesNumber; i++) {
                attendee = new Attendee();
                festivalFestivalGate.addTicketInQueue(attendee.getTicketType());
                setPositionInQue(getPositionInQue() + 1);
                System.out.println("at position number  " + getPositionInQue() + " attendee has  " + attendee.getTicketType() + " ticket type");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }

            }
        }
    }

    public int getPositionInQue() {
        return positionInQue;
    }

    public void setPositionInQue(int positionInQue) {
        this.positionInQue = positionInQue;
    }

}



