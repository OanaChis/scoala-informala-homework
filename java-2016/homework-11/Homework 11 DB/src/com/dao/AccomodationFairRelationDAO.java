package com.dao;


import com.db.BookingException;
import com.model.AccomodationFairRelation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oana on 3/16/2017.
 *this is an interface for DAO accomodation_fair_relation

 */

public interface AccomodationFairRelationDAO {


    void setAll() throws BookingException, SQLException;


    List<AccomodationFairRelation> getAll() throws BookingException, SQLException;

}
