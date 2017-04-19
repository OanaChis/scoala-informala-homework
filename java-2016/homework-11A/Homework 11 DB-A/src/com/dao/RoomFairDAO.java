package com.dao;


import com.db.BookingException;
import com.model.RoomFair;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oana on 3/16/2017.
 *this is an interface for DAO room_fair
 * this contains CRUD methods
 */

public interface RoomFairDAO {
    //C
    void add(RoomFair roomFair) throws BookingException, SQLException;

    //R
    List<RoomFair> getAll() throws BookingException, SQLException;

    //U
    void update(RoomFair roomFair) throws BookingException, SQLException;

    //D
    void delete(RoomFair roomFair) throws BookingException, SQLException;
}
