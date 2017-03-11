package com.example;

/**
 * Created by Oana on 3/6/2017.
 */

    /**This is the FestivalStatisticsThread class that have
     * the goal to implement our festival statistics

     */
    public class FestivalStatisticsThread extends Thread {

        private FestivalGate festivalFestivalGate = new FestivalGate();

        public FestivalStatisticsThread(FestivalGate festivalFestivalGate) {
            this.festivalFestivalGate = festivalFestivalGate;
            setDaemon(true);
        }


        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);

                    if (!festivalFestivalGate.getTheLine().isEmpty())
                        festivalFestivalGate.countTicketsOnGate();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

