package edu.gatech.seclass.gobowl.models;

import android.support.annotation.Nullable;

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
        listOfColumns.add("active");
    }

    public BowlingParty() {
        super();
        setup();
        setString("starttime", Long.toString((new Date()).getTime()));
        setString("lane", "0");
        setString("active", "0");
        newRecord = true;
    }

    public BowlingParty(String lane) {
        super();
        setup();
        fetchByColumn("lane", lane);
    }

    public void addBowler(Bowler b) {
        if (newRecord) {
            saveRecord();
        }

        BowlerToParty b2p = new BowlerToParty();

        b2p.setString("bowlerid", b.getString("id"));
        b2p.setString("partyid", getString("id"));
        b2p.saveRecord();
    }

    @Nullable
    public static BowlingParty getByBowler(Bowler b) {
        String id = b.getString("id");
        ArrayList<String> ids = BowlerToParty.getPartyIds(id);
        if (ids == null) {
            return null;
        }

        for (String bpid: ids) {
            BowlingParty bp = new BowlingParty();
            bp.fetchById(bpid);
            if (bp.getString("active").equals("1")) {
                return bp;
            }
        }
        return null;
    }

    public int numBowlers() {
        return this.getInteger("numberofbowlers");
    }

}
