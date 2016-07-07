package edu.gatech.seclass.gobowl.models;

import java.util.ArrayList;

/**
 * Created by charles on 7/7/16.
 */
public class BowlerToParty extends DatabaseEntity {
    private void setup() {
        tableName = "bowlertoparty";
        listOfColumns = new ArrayList<>();
        listOfColumns.add("id");
        listOfColumns.add("bowlerid");
        listOfColumns.add("partyid");
    }

    public BowlerToParty() {
        super();
        setup();
    }

    public static BowlerToParty getByBowler(String bowlerId) {
        BowlerToParty b2p = new BowlerToParty();
        b2p.fetchByColumn("bowlerid", bowlerId);
        if (b2p.instanceData == null) {
            return null;
        }
        return b2p;
    }
}
