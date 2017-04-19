package com.dao.sql;


import com.dao.RoomFairDAO;
import com.db.BookingException;
import com.db.ConnectionToBookingDB;
import com.model.RoomFair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana on 3/16/2017.
 */


public class RoomFairDAOSQL implements RoomFairDAO {

    private ConnectionToBookingDB connectionToBookingDB = new ConnectionToBookingDB();

    public RoomFairDAOSQL(ConnectionToBookingDB connectionToBookingDB) {
        this.connectionToBookingDB = connectionToBookingDB;
    }

    /**
     * This method will return a list of roomFair objects
     */

    @Override
    public List<RoomFair> getAll() throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from room_fair;");
            ArrayList<RoomFair> roomFairArrayList = new ArrayList<>();
            while (resultSet.next()) {
                roomFairArrayList.add(mapResultSetToRoomFair(resultSet));
            }
            return roomFairArrayList;
        }
    }

    /**
     * this method will return an accomodation object
     */

    private RoomFair mapResultSetToRoomFair(ResultSet resultSet) throws SQLException {
        RoomFair rf = new RoomFair(resultSet.getDouble("value"),
                resultSet.getString("season"));
        rf.setId(resultSet.getInt("id"));
        return rf;
    }


    /**
     * This method will add into roomFair table a row with object roomFair , all the info will be from
     * roomFair class
     */
    @Override
    public void add(RoomFair roomFair) throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into room_fair(value,season) values('" +
                    roomFair.getValue() + "','" + roomFair.getSeason() + "');");
            ResultSet resultSet = statement.executeQuery("select currval('room_fair_ids');");
            resultSet.next();
            roomFair.setId(resultSet.getInt(1));
        }
    }

    /**
     * This will update a roomFair object based on certain criteria
     */
    @Override
    public void update(RoomFair roomFair) throws BookingException, SQLException {
        try (java.sql.Connection connection = this.connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE room_fair SET value = '" + roomFair.getValue() + "'," +
                    " season = '" + roomFair.getSeason() + "' WHERE id = " + roomFair.getId() + ";");
        }
    }

    /**
     * This method will delete by id the from date base
     */
    @Override
    public void delete(RoomFair roomFair) throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            statement.execute("delete from room_fair WHERE id=" + roomFair.getId() + ";");
        }
    }
}
