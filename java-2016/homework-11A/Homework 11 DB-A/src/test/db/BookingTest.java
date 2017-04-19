package test.db;

import com.db.BookingException;
import com.db.ConnectionToBookingDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BookingTest extends ConnectionToBookingDB {
    /**
     * Creates a connection to the PostgreSQL without selecting a database
     *
     * @return
     * @throws SQLException
     * @throws BookingException
     */

    private Connection connectToPostgreSQL() throws SQLException, BookingException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            java.sql.Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")
                    .append(":")

                    .append(5432)
                    .append("/")
                    .append("booking")
                    .append("?user=")

                    .append("postgres")
                    .append("&password=")
                    .append("password").toString();
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new BookingException("Could not load DB driver.", e);
        }
    }

    public Connection connect() throws BookingException, SQLException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("booking_test")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("password").toString();
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new BookingException("Could not load DB driver.", e);
        }
    }

    public static void setUpTestDB() throws BookingException, SQLException {
        BookingTest bdt = new BookingTest();
        try (Connection connection = bdt.connectToPostgreSQL()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE booking_test;");
        }


        // connect to newly created tests database and create tables.

        try (Connection connection = bdt.connect()) {
            StringBuilder builder = new StringBuilder();

            builder.append("CREATE SEQUENCE accomodation_ids;");
            builder.append("CREATE TABLE accomodation(id INT PRIMARY KEY DEFAULT NEXTVAL('accomodation_ids'), " + "type VARCHAR(32), bed_type VARCHAR(32), max_guests INT, description VARCHAR(512));");
            builder.append("CREATE SEQUENCE room_fair_ids;");
            builder.append("CREATE TABLE room_fair(id INT PRIMARY KEY DEFAULT NEXTVAL('room_fair_ids'), " + "value DOUBLE PRECISION, season VARCHAR(32));");
            builder.append("CREATE SEQUENCE accomodation_fair_relation_ids;");
            builder.append("CREATE TABLE accomodation_fair_relation(id INT PRIMARY KEY DEFAULT NEXTVAL " + "('accomodation_fair_relation_ids'), id_accomodation INT REFERENCES accomodation(id), " + "id_room_fair INT REFERENCES room_fair(id));");
            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());
        }
    }

    public static void dropTestDB() throws BookingException, SQLException {
        BookingTest bdt = new BookingTest();
        try (Connection connection = bdt.connectToPostgreSQL()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP DATABASE booking_test;");
        }
    }

    public void dropDataFromTables() throws BookingException, SQLException {
        try (Connection connection = connect()) {
            StringBuilder builder = new StringBuilder();
            builder.append("DELETE FROM accomodation_fair_relation;");
            builder.append("DELETE FROM accomodation;");
            builder.append("DELETE FROM room_fair;");
            Statement statement = connection.createStatement();
            statement = connection.createStatement();
            statement.execute(builder.toString());
        }


    }
}



