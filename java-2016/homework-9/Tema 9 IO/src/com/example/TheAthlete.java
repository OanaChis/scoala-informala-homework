package com.example;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Oana on 2/28/2017.
 */
public class TheAthlete implements Serializable {
    private static final long serialVersionUID = 1;
    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private Date skiTimeResult;
    private String firstShootingRange;
    private String secondShootingRange;
    private String thirdShootingRange;


    /**
     * below methods are for getters , in order to access all the fields
     *
     * @return
     */


    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Date getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    /**
     * this is only to set the values for fields
     *
     * @param
     */

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setSkiTimeResult(Date skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        this.secondShootingRange = secondShootingRange;
    }

    public void setThirdShootingRange(String thirdShootingRange) {
        this.thirdShootingRange = thirdShootingRange;
    }

    /**
     * this method will override to string method in order to print the content of an object
     *
     * @return
     */

    @Override
    public String toString() {
        return "TheAthlete{" +
                "athleteNumber=" + athleteNumber +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult=" + skiTimeResult +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                '}';
    }


    /**
     * this will override equals
     *
     * @param o
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TheAthlete athlete = (TheAthlete) o;

        if (getAthleteNumber() != athlete.getAthleteNumber()) return false;
        if (!getAthleteName().equals(athlete.getAthleteName())) return false;
        if (!getCountryCode().equals(athlete.getCountryCode())) return false;
        if (!getSkiTimeResult().equals(athlete.getSkiTimeResult())) return false;
        if (!getFirstShootingRange().equals(athlete.getFirstShootingRange())) return false;
        if (!getSecondShootingRange().equals(athlete.getSecondShootingRange())) return false;
        return getThirdShootingRange().equals(athlete.getThirdShootingRange());
    }

    /**
     * this method will override hashcode
     *
     * @return
     */

    @Override
    public int hashCode() {
        int result = getAthleteNumber();
        result = 31 * result + getAthleteName().hashCode();
        result = 31 * result + getCountryCode().hashCode();
        result = 31 * result + getSkiTimeResult().hashCode();
        result = 31 * result + getFirstShootingRange().hashCode();
        result = 31 * result + getSecondShootingRange().hashCode();
        result = 31 * result + getThirdShootingRange().hashCode();
        return result;
    }


}
