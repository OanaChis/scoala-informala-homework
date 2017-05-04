package com.dao;


import com.db.BookingException;
import com.model.Accomodation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oana on 3/16/2017.
 * this is an interface for DAO accommodation
 * this contains CRUD methods
 */


public interface AccomodationDAO {
    //C
    void add(Accomodation accomodation) throws BookingException, SQLException;

    //R
    List<Accomodation> getAll() throws BookingException, SQLException;

    //U
    void update(Accomodation accomodation) throws BookingException, SQLException;

    //D
    void delete(Accomodation accomodation) throws BookingException, SQLException;
}
