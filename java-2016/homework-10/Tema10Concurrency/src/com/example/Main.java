package com.example;

/**
 * Created by Oana on 3/6/2017.
 */


/**
 * This is the Main class where we will have the main method
 * where we will create a gate a festival attendee thread and a festival statistics thread
 */
public class Main {

    public static void main(String[] args) {
        FestivalGate festivalGateTomorrowland = new FestivalGate();
        FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(festivalGateTomorrowland);
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(festivalGateTomorrowland);

        festivalAttendeeThread.start();
        festivalStatisticsThread.start();


    }
}

