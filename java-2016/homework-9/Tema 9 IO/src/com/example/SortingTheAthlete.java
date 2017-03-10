package com.example;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Oana on 2/28/2017.
 * in here we will calculate results after the shooting range and we will sort all participants based on ski time result
 */
public class SortingTheAthlete {

    /**
     * this method will sort the athletes bases on ski time result
     * @param theAthleteList
     * @return a sorted list based on ski time result
     */


    public List<TheAthlete> sortTheAthletes(List<TheAthlete> theAthleteList) {

        Collections.sort(theAthleteList, new Comparator<TheAthlete>() {
            @Override
            public int compare(TheAthlete o1, TheAthlete o2) {

                return o1.getSkiTimeResult().compareTo(o2.getSkiTimeResult());
            }
        });
        return theAthleteList;
    }

    /**
     * This method calculate the shots .
     *
     * @param theAthleteList list of Athletes.
     */
    public void resultsShootingRange(List<TheAthlete> theAthleteList) {

        Calendar myCalendar = Calendar.getInstance();

        for (TheAthlete athlt : theAthleteList) {
            myCalendar.setTime(athlt.getSkiTimeResult());

            for (char character : athlt.getFirstShootingRange().toCharArray()) {
                if (character == 'o') {
                    myCalendar.add(Calendar.SECOND, 10);
                }
            }

            for (char character : athlt.getSecondShootingRange().toCharArray()) {
                if (character == 'o') {
                    myCalendar.add(Calendar.SECOND, 10);
                }
            }

            for (char character : athlt.getThirdShootingRange().toCharArray()) {
                if (character == 'o') {
                    myCalendar.add(Calendar.SECOND, 10);
                }
            }
            athlt.setSkiTimeResult(myCalendar.getTime());
        }
    }


    /**
     * This method will return the sorted list of athletes
     *
     * @param athletes the list of Athletes we want to evaluate.
     * @return the sorted list of athletes
     */


    public List<TheAthlete> calculateAthleteOrder(List<TheAthlete> athletes) {
        resultsShootingRange(athletes);
        sortTheAthletes(athletes);
        return athletes;
    }


}

