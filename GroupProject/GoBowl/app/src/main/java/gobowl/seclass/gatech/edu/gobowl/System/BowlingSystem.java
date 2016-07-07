package gobowl.seclass.gatech.edu.gobowl.System;

import java.util.HashMap;

import edu.gatech.seclass.services.QRCodeService;

/**
 * Created by charles on 7/6/16.
 */
public class BowlingSystem implements Customer {
    private static BowlingSystem ourInstance = new BowlingSystem();

    public static BowlingSystem getInstance() {
        return ourInstance;
    }

    private Bowler leadBowler = null;

    /*
        Login: Hit the scanner, look up the customer.

        Returns first name if found, or "" if not.
     */

    @Override
    public String login() {
        String id;
        id = QRCodeService.scanQRCode();

        if (id.equals("ERR")) {
            return "";
        }

        leadBowler = new Bowler(id);

        return leadBowler.firstName;
    }

    @Override
    public String getFirstName() {
        if (leadBowler == null) {
            System.out.printf("*** ERROR: BowlingSystem: No Lead Bowler!\n");
            return "";
        }
        return leadBowler.firstName;
    }
}
