package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Oana on 2/28/2017.
 */
public class JunitTestClass {


    @Test
    public void readNumber() throws ParseException {
        File file = new File("C:" + File.separator + "Users" + File.separator + "Oana" + File.separator + "Desktop" + File.separator + "Tema 9 IO" + File.separator + "TheAthlete.csv");
        Main.Read myReader = new Main.Read();
        List<TheAthlete> athleteList = null;
        try {
            athleteList = myReader.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(1, athleteList.get(1).getAthleteNumber());
    }

    @Test
    public void readName() throws ParseException {
        File file = new File("C:" + File.separator + "Users" + File.separator + "Oana" + File.separator + "Desktop" + File.separator + "Tema 9 IO" + File.separator + "TheAthlete.csv");
        Main.Read myReader = new Main.Read();
        List<TheAthlete> athleteList = null;
        try {
            athleteList = myReader.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("Piotr Smitzer", athleteList.get(0).getAthleteName());
    }

    @Test
    public void readCountryCode() throws ParseException {
        File file = new File("C:" + File.separator + "Users" + File.separator + "Oana" + File.separator + "Desktop" + File.separator + "Tema 9 IO" + File.separator + "TheAthlete.csv");
        Main.Read myReader = new Main.Read();
        List<TheAthlete> athleteList = null;
        try {
            athleteList = myReader.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertEquals("RO", athleteList.get(2).getCountryCode());
    }


}


