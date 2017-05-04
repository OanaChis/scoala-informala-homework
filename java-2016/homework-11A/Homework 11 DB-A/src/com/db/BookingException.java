package com.db;


/**
 * Created by Oana on 3/20/2017.
 * this is a class only to handle exception
 */

public class BookingException extends Throwable {
    public BookingException(String s, Exception e) {
        super(s, e);
    }
}
