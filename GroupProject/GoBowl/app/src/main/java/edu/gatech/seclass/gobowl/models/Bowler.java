package edu.gatech.seclass.gobowl.models;

import java.util.ArrayList;

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

    public static Bowler findByName(String name) {
        Bowler b = new Bowler();
        b.fetchByColumn("last", name);

        if (b.instanceData == null) {
            return null;
        }

        return b;
    }

    public static Bowler findByEmail(String email) {
        Bowler b = new Bowler();
        b.fetchByColumn("email", email.toLowerCase());

        if (b.instanceData == null) {
            return null;
        }

        return b;
    }

}
