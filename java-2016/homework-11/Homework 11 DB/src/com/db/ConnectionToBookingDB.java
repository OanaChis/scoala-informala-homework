package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Oana on 3/20/2017.
 * this class will load driver and open a connection for booking db
 */

public class ConnectionToBookingDB {


    public Connection connect() throws BookingException, SQLException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append("localhost")// server local
                    .append(":")
                    .append(5432)//port
                    .append("/")
                    .append("booking")//existing db
                    .append("?user=")
                    .append("postgres")//user
                    .append("&password=")
                    .append("password").toString();// pass to connect
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new BookingException("Could not load DB driver.", e);
        }
    }
}


