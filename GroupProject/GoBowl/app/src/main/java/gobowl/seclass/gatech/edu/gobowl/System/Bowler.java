package gobowl.seclass.gatech.edu.gobowl.System;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by charles on 7/6/16.
 */
public class Bowler extends DatabaseEntity {
    private void setup() {
        tableName = "customers";
        listOfColumns = new ArrayList<>();
        listOfColumns.add("id");
        listOfColumns.add("first");
        listOfColumns.add("last");
        listOfColumns.add("email");
        listOfColumns.add("vip");
        listOfColumns.add("ytd");
    }

    public Bowler() {
        super();
        setup();
        this.setBoolean("vip", false);
        this.setDouble("ytd", 0.0);
    }

    public Bowler(String hexid) {
        super();
        setup();
        fetchById(hexid);
    }
}
