package com;


import com.dao.sql.AccomodationDAOSQL;
import com.dao.sql.AccomodationFairRelationDAOSQL;
import com.dao.sql.RoomFairDAOSQL;
import com.db.BookingException;
import com.db.ConnectionToBookingDB;
import com.model.Accomodation;
import com.model.RoomFair;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana on 3/29/2017.
 */


public class Main {
    public static void main(String[] args) throws BookingException, SQLException {

        ConnectionToBookingDB connectionToBookingDB = new ConnectionToBookingDB();
        MyDb myDb = new MyDb(connectionToBookingDB);
        //  myDb.resetDb();
        myDb.createBookingDb();

        AccomodationDAOSQL accomodationDAO = new AccomodationDAOSQL(connectionToBookingDB);
        RoomFairDAOSQL roomFairDAO = new RoomFairDAOSQL(connectionToBookingDB);
        AccomodationFairRelationDAOSQL accomodationFairRelationDAO = new AccomodationFairRelationDAOSQL(connectionToBookingDB);

        Accomodation accom1 = new Accomodation("single", "single", 1, "good");
        Accomodation accom2 = new Accomodation("double", "twin", 2, "good");
        Accomodation accom3 = new Accomodation("double deluxe", "matrimonial", 2, "very good");

        accomodationDAO.add(accom1);
        accomodationDAO.add(accom2);
        accomodationDAO.add(accom3);


        RoomFair room1 = new RoomFair(225, "season 1");
        RoomFair room2 = new RoomFair(350, "season 2");
        RoomFair room3 = new RoomFair(400, "season 3");

        roomFairDAO.add(room1);
        roomFairDAO.add(room2);
        roomFairDAO.add(room3);

        List<RoomFair> roomFairList = new ArrayList<>() ;

        accomodationFairRelationDAO.setAll();

    }

    /**
     * Created by Oana on 3/29/2017.
     */

    public static class MyDb {

        private ConnectionToBookingDB connectionToBookingDB = new ConnectionToBookingDB();

        public MyDb(ConnectionToBookingDB connectionToBookingDB) {
            this.connectionToBookingDB = connectionToBookingDB;
        }

        public void createBookingDb() throws BookingException, SQLException {

            try (Connection connection = connectionToBookingDB.connect()) {
                StringBuilder builder = new StringBuilder();

                builder.append("create sequence  accomodation_ids;");
                builder.append("create table accomodation(id INT PRIMARY KEY DEFAULT NEXTVAL('accomodation_ids'), " + "type VARCHAR(32), bed_type VARCHAR(32), max_guests INT, description VARCHAR(512));");
                builder.append("CREATE SEQUENCE room_fair_ids;");
                builder.append("CREATE TABLE room_fair(id INT PRIMARY KEY DEFAULT NEXTVAL('room_fair_ids'), " + "value DOUBLE PRECISION, season VARCHAR(32));");
                builder.append("CREATE SEQUENCE accomodation_fair_relation_ids;");
                builder.append("CREATE TABLE accomodation_fair_relation(id INT PRIMARY KEY DEFAULT NEXTVAL " + "('accomodation_fair_relation_ids'), id_accomodation INT REFERENCES accomodation(id), " + "id_room_fair INT REFERENCES room_fair(id));");
                Statement statement = connection.createStatement();
                statement.execute(builder.toString());
            }
        }

        public void resetDb() throws BookingException, SQLException {
            try (Connection connection = connectionToBookingDB.connect()) {
                Statement statement = connection.createStatement();
                statement.execute("DROP TABLE accomodation_fair_relation , accomodation , room_fair;");
                statement.execute("DROP SEQUENCE accomodation_ids,room_fair_ids,accomodation_fair_relation_ids;");
            }
        }
    }
}
