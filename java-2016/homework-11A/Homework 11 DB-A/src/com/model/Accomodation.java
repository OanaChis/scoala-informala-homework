package com.model;

/**
 * Created by Oana on 3/14/2017.
 */

public class Accomodation {
    private int id;
    private String type;
    private String bed_Type;
    private int max_Guests;
    private String description;

    public Accomodation(String type, String bed_Type, int max_Guests, String description) {
        this.type = type;
        this.bed_Type = bed_Type;
        this.max_Guests = max_Guests;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBed_Type() {
        return bed_Type;
    }

    public void setBed_Type(String bed_Type) {
        this.bed_Type = bed_Type;
    }

    public int getMax_Guests() {
        return max_Guests;
    }

    public void setMax_Guests(int max_Guests) {
        this.max_Guests = max_Guests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accomodation that = (Accomodation) o;

        if (id != that.id) return false;
        if (max_Guests != that.max_Guests) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (bed_Type != null ? !bed_Type.equals(that.bed_Type) : that.bed_Type != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (bed_Type != null ? bed_Type.hashCode() : 0);
        result = 31 * result + max_Guests;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Accomodation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", bed_Type='" + bed_Type + '\'' +
                ", max_Guests=" + max_Guests +
                ", description='" + description + '\'' +
                '}';
    }
}
