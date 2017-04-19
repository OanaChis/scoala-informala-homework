package com.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana on 2/28/2017.
 */

public class Main {

    public static void main(String[] args) throws IOException, ParseException {


        /**
         * this is the list of athletes
         */
        List<TheAthlete> theAthleteList;

        /**
         * a new object of file type was created and the absolute path to the .cvs file was provided
         */

        File fileRead = new File("C:" + File.separator + "Users" + File.separator + "Oana" + File.separator + "Desktop" + File.separator + "Tema 9 IO" + File.separator + "TheAthlete.csv");


        SortingTheAthlete sortingTheAthlete = new SortingTheAthlete();
        Read myReader = new Read();


        theAthleteList = myReader.readFile(fileRead);

        theAthleteList = sortingTheAthlete.calculateAthleteOrder(myReader.getTheAthleteList());


        System.out.println("This is the ordered list based on the best ski time result obtained by an athlete");

        System.out.println("=======================================================");
        theAthleteList.forEach(System.out::println);

    }

    /**
     * this method will split the cvs file and it will store all the date into a athlete object
     */

    public static class Read {


        private ArrayList<TheAthlete> theAthleteList = new ArrayList<>();

        public List<TheAthlete> getTheAthleteList() {
            return theAthleteList;
        }

        private TheAthlete getAthlete(String myLine) throws ParseException {

            TheAthlete athlete = new TheAthlete();

            String[] someString = myLine.split(",");


            if (someString.length < 7) {
                throw new ExceptionForAthlete("athlete data not completed.");
            } else {
                athlete.setAthleteNumber(Integer.parseInt(someString[0]));
                athlete.setAthleteName(someString[1]);
                athlete.setCountryCode(someString[2]);
                athlete.setSkiTimeResult(new SimpleDateFormat("mm:ss").parse(someString[3]));
                athlete.setFirstShootingRange(someString[4]);
                athlete.setSecondShootingRange(someString[5]);
                athlete.setThirdShootingRange(someString[6]);


            }
            return athlete;
        }


        public List<TheAthlete> readFile(File file) throws IOException, ParseException {
            String myLine;
            boolean column = true;


            try (BufferedReader path = new BufferedReader(new FileReader(file))) {

                while ((myLine = path.readLine()) != null) {
                    if (!column) {
                        theAthleteList.add(getAthlete(myLine));
                    } else {
                        column = false;
                    }
                }
            } catch (IOException ex) {

                throw ex;
            }


            return theAthleteList;


        }
    }


}








