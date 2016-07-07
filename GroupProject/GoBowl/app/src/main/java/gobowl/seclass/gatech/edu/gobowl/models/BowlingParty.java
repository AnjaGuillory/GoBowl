package gobowl.seclass.gatech.edu.gobowl.models;

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

    public static BowlingParty getByBowler(Bowler b) {
        String id = b.getString("id");
        BowlerToParty b2p = BowlerToParty.getByBowler(id);

        BowlingParty bp = new BowlingParty();
        bp.fetchById(b2p.getString("partyid"));
        return bp;
    }

}
