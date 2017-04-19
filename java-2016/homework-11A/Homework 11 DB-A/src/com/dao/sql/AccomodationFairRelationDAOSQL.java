package com.dao.sql;


import com.dao.AccomodationFairRelationDAO;
import com.db.BookingException;
import com.db.ConnectionToBookingDB;
import com.model.AccomodationFairRelation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana on 3/16/2017.
 */

public class AccomodationFairRelationDAOSQL implements AccomodationFairRelationDAO {

    private ConnectionToBookingDB connectionToBookingDB = new ConnectionToBookingDB();

    public AccomodationFairRelationDAOSQL(ConnectionToBookingDB connectionToBookingDB) {
        this.connectionToBookingDB = connectionToBookingDB;
    }


    /**
     * this will return an accomodation fair relation object
     */
    private AccomodationFairRelation mapResultSetToAccomodationFairRelation(ResultSet resultSet) throws SQLException {
        AccomodationFairRelation accomodationFairRelation = new AccomodationFairRelation(resultSet.getInt(1),
                resultSet.getInt(2));
        accomodationFairRelation.setId(resultSet.getInt("id"));
        return accomodationFairRelation;
    }

    /**
     * This method will set up the accomodation_fair_relation table
     * using a join
     */
    @Override
    public void setAll() throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            StringBuilder builder = new StringBuilder();
            builder.append("delete from accomodation_fair_relation;");
            builder.append("alter sequence accomodation_ids restart WITH 1;");
            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());
        }
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select accomodation.id,room_fair.id from accomodation join room_fair ON accomodation.id=room_fair.id;");
            statement = connection.createStatement();

            while (resultSet.next()) {
                statement.executeUpdate("insert into accomodation_fair_relation(id_accomodation,id_room_fair) values('" +
                        resultSet.getInt(1) + "','" + resultSet.getInt(2) + "');");
            }
        }
    }

    /**
     * /**
     * This method will return a list of accomodation fair relation objects
     */

    @Override
    public List<AccomodationFairRelation> getAll() throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from accomodation_fair_relation;");
            ArrayList<AccomodationFairRelation> accomodationFairRelationArrayList = new ArrayList<>();
            while (resultSet.next()) {
                accomodationFairRelationArrayList.add(mapResultSetToAccomodationFairRelation(resultSet));
            }
            return accomodationFairRelationArrayList;
        }
    }

}
