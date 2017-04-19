package com.dao.sql;


import com.dao.AccomodationDAO;
import com.db.BookingException;
import com.db.ConnectionToBookingDB;
import com.model.Accomodation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana on 3/16/2017.
 * in here we will implement all CRUD methods from accomodationDAO interface
 */


public class AccomodationDAOSQL implements AccomodationDAO {

    private ConnectionToBookingDB connectionToBookingDB = new ConnectionToBookingDB();

    public AccomodationDAOSQL(ConnectionToBookingDB connectionToBookingDB) {
        this.connectionToBookingDB = connectionToBookingDB;
    }


    /**
     * This method will return a list of accomodation objects
     */
    @Override
    public List getAll() throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from accomodation;");
            ArrayList<Accomodation> accomodations = new ArrayList<>();
            while (resultSet.next()) {
                accomodations.add(mapResultSetToAccomodation(resultSet));
            }
            return accomodations;
        }
    }

    /**
     * this method will return an accomodation object
     */
    private Accomodation mapResultSetToAccomodation(ResultSet resultSet) throws SQLException {
        Accomodation accomodation = new Accomodation(resultSet.getString("type"),
                resultSet.getString("bed_type"),
                resultSet.getInt("max_guests"),
                resultSet.getString("description"));
        accomodation.setId(resultSet.getInt("id"));
        return accomodation;
    }

    /**
     * This will update a accomodation object based on certain criteria
     */
    @Override
    public void update(Accomodation accomodation) throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update accomodation SET type = '" + accomodation.getType() + "'," + " bed_type = '" + accomodation.getBed_Type() + "', max_guests = '" + accomodation.getMax_Guests() + "'," + " description = '" + accomodation.getDescription() + "' WHERE id = " + accomodation.getId() + ";");
        }
    }

    /**
     * This method will delete by id rows from table by id
     */
    @Override
    public void delete(Accomodation accomodation) throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            statement.execute("delete from accomodation where id=" + accomodation.getId() + ";");
        }
    }

    /**
     * This method will add into accomodation table a row with object accomodation , all the info will be from
     * accomodation class
     */
    @Override
    public void add(Accomodation accomodation) throws BookingException, SQLException {
        try (Connection connection = connectionToBookingDB.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into accomodation(type,bed_type,max_guests,description) values('" +
                    accomodation.getType() + "','" + accomodation.getBed_Type() + "','" + accomodation.getMax_Guests() + "','" +
                    accomodation.getDescription() + "');");
            ResultSet resultSet = statement.executeQuery("select currval('accomodation_ids');");
            resultSet.next();
            accomodation.setId(resultSet.getInt(1));
        }
    }
}
