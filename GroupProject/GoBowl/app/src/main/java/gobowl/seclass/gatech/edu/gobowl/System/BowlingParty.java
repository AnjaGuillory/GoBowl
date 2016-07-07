package gobowl.seclass.gatech.edu.gobowl.System;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by charles on 7/7/16.
 */
public class BowlingParty extends DatabaseEntity {
    private void setup() {
        tableName = "bowlingparty";
        listOfColumns = new ArrayList<>();
        listOfColumns.add("id");
        listOfColumns.add("numberofbowlers");
        listOfColumns.add("starttime");
        listOfColumns.add("endtime");
        listOfColumns.add("lane");
    }

    public BowlingParty() {
        super();
        setup();
        setString("starttime", Long.toString((new Date()).getTime()));
        setString("lane", "0");
    }

    public BowlingParty(String lane) {
        super();
        setup();
        fetchByColumn("lane", lane);
    }

}
