package gobowl.seclass.gatech.edu.gobowl.models;

import java.util.HashMap;

/**
 * Created by charles on 7/7/16.
 */
public class Lane {

    public static int getFreeLane() {

        Persistence per = Persistence.getInstance();

        HashMap<String,String> maxlane = per.getRecordbySQL("select max(lane) from bowlingparty where active='1'");

        if (maxlane == null || maxlane.get("max(lane)") == null) {
            return 1;
        }

        return 1 + Integer.parseInt(maxlane.get("max(lane)"));

    }

}
