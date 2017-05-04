package test.sql;


import com.dao.sql.AccomodationDAOSQL;
import com.dao.sql.AccomodationFairRelationDAOSQL;
import com.dao.sql.RoomFairDAOSQL;
import com.db.BookingException;
import com.model.Accomodation;
import com.model.RoomFair;
import org.junit.*;
import test.db.BookingTest;

import java.sql.SQLException;
import java.util.List;

/**
 * integration test between DAO and DB
 */
public class SQLDAOBookingTest {

    BookingTest bookingDbTest;

    AccomodationDAOSQL accomodationDAOSQL;
    RoomFairDAOSQL roomFairDAOSQL;
    AccomodationFairRelationDAOSQL accomodationFairRelationDAOSQL;

    @BeforeClass
    public static void initTests() throws BookingException, SQLException {
        BookingTest.setUpTestDB();
    }

    @AfterClass
    public static void discardTests() throws BookingException, SQLException {
        BookingTest.dropTestDB();
    }

    @Before
    public void setUp() {
        bookingDbTest = new BookingTest();
        accomodationDAOSQL = new AccomodationDAOSQL(bookingDbTest);
        roomFairDAOSQL = new RoomFairDAOSQL(bookingDbTest);
        accomodationFairRelationDAOSQL = new AccomodationFairRelationDAOSQL(bookingDbTest);
    }

    @After
    public void tearDown() throws BookingException, SQLException {
        bookingDbTest.dropDataFromTables();
    }

    @Test
    public void insert_accomodations() throws BookingException, SQLException {
        Accomodation accomodation1 = new Accomodation("single", "single", 1, "good");
        Accomodation accomodation2 = new Accomodation("double", "twin ", 2, "good");
        Accomodation accomodation3 = new Accomodation("double deluxe", "marimonial", 2, "very good");
        accomodationDAOSQL.add(accomodation1);
        accomodationDAOSQL.add(accomodation2);
        accomodationDAOSQL.add(accomodation3);
        List<Accomodation> list = accomodationDAOSQL.getAll();
        Assert.assertArrayEquals(new Accomodation[]{accomodation1, accomodation2, accomodation3}, list.toArray());
    }

    @Test
    public void delete_accomodations() throws BookingException, SQLException {
        Accomodation accomodation1 = new Accomodation("single", "single", 1, "good");
        Accomodation accomodation2 = new Accomodation("double", "twin ", 2, "good");
        accomodationDAOSQL.add(accomodation1);
        accomodationDAOSQL.add(accomodation2);

        accomodationDAOSQL.delete(accomodation1);
        accomodationDAOSQL.delete(accomodation2);

        List<Accomodation> accomodationList = accomodationDAOSQL.getAll();

        Assert.assertEquals(0, accomodationList.size());
    }

    @Test
    public void update_accomodation_into_db() throws BookingException, SQLException {
        Accomodation accom1 = new Accomodation("single", "single", 1, "good");
        Accomodation accom2 = new Accomodation("double", "twin", 2, "good");
        accomodationDAOSQL.add(accom1);
        accomodationDAOSQL.add(accom2);

        accom1.setType(accom2.getType());
        accom1.setBed_Type(accom2.getBed_Type());
        accom1.setMax_Guests(accom2.getMax_Guests());
        accom1.setDescription(accom2.getDescription());

        accomodationDAOSQL.update(accom1);

        List<Accomodation> list = accomodationDAOSQL.getAll();

        Assert.assertEquals(accom2, list.get(0));
    }

    @Test
    public void insert_room_fair() throws BookingException, SQLException {
        RoomFair r1 = new RoomFair(225, "season 1");
        RoomFair r2 = new RoomFair(350, "season 2");
        RoomFair r3 = new RoomFair(400, "season 3");

        roomFairDAOSQL.add(r1);
        roomFairDAOSQL.add(r2);
        roomFairDAOSQL.add(r3);

        List<RoomFair> list = roomFairDAOSQL.getAll();

        Assert.assertArrayEquals(new RoomFair[]{r1, r2, r3}, list.toArray());
    }

    @Test
    public void delete_room_fair() throws BookingException, SQLException {
        RoomFair r1 = new RoomFair(225, "season 1");
        RoomFair r2 = new RoomFair(350, "season 2");
        roomFairDAOSQL.add(r1);
        roomFairDAOSQL.add(r2);

        roomFairDAOSQL.delete(r1);

        List<RoomFair> list = roomFairDAOSQL.getAll();

        Assert.assertEquals(1, list.size());
    }

    @Test
    public void update_room_fair() throws BookingException, SQLException {
        RoomFair r1 = new RoomFair(225, "season 1");
        RoomFair r2 = new RoomFair(350, "season 2");
        roomFairDAOSQL.add(r1);
        roomFairDAOSQL.add(r2);

        r1.setValue(r2.getValue());
        r1.setSeason(r2.getSeason());


        roomFairDAOSQL.update(r1);

        List<RoomFair> list = roomFairDAOSQL.getAll();

        Assert.assertEquals(r2, list.get(0));
    }


}
