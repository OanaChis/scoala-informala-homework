package com.model;

/**
 * Created by Oana on 3/16/2017.
 */

public class AccomodationFairRelation {

    private int id;
    private int id_Accomodation;
    private int id_Room_Fair;

    public AccomodationFairRelation(int id_Accomodation, int id_Room_Fair) {
        this.id_Accomodation = id_Accomodation;
        this.id_Room_Fair = id_Room_Fair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Accomodation() {
        return id_Accomodation;
    }

    public void setId_Accomodation(int id_Accomodation) {
        this.id_Accomodation = id_Accomodation;
    }

    public int getId_Room_Fair() {
        return id_Room_Fair;
    }

    public void setId_Room_Fair(int id_Room_Fair) {
        this.id_Room_Fair = id_Room_Fair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccomodationFairRelation that = (AccomodationFairRelation) o;

        if (id != that.id) return false;
        if (id_Accomodation != that.id_Accomodation) return false;
        return id_Room_Fair == that.id_Room_Fair;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_Accomodation;
        result = 31 * result + id_Room_Fair;
        return result;
    }

    @Override
    public String toString() {
        return "AccomodationFairRelation{" +
                "id=" + id +
                ", id_Accomodation=" + id_Accomodation +
                ", id_Room_Fair=" + id_Room_Fair +
                '}';
    }
}
