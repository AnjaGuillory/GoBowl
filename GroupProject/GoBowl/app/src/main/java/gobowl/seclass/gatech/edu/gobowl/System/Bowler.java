package gobowl.seclass.gatech.edu.gobowl.System;

import java.util.HashMap;

/**
 * Created by charles on 7/6/16.
 */
public class Bowler {
    public String firstName = null;
    public String lastName = null;
    public String email = null;
    public String id = null;
    public Boolean vipStatus = null;
    public Double ytdSpend = null;

    public Bowler(String hexid) {
        HashMap<String,String> data = Persistence.getInstance().getCustomer(hexid);
        if (data == null) {
            System.out.printf("ERROR: Bowler: No match for id %s\n", hexid);
            return;     // Nobody that matches!!!!
        }

        firstName = data.get("first");
        lastName = data.get("last");
        email = data.get("email");
        id = hexid;
        vipStatus = data.get("vip").equals("true");
        ytdSpend = Double.valueOf(data.get("ytd"));
    }

    public Bowler(String first, String last, String email) {


    }


}
