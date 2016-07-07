package gobowl.seclass.gatech.edu.gobowl.System;

import java.util.HashMap;

import edu.gatech.seclass.services.PrintingService;
import edu.gatech.seclass.services.QRCodeService;

/**
 * Created by charles on 7/6/16.
 */
public class BowlingSystem implements Customer, Manager {
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

        return leadBowler.getString("first");
    }

    @Override
    public String getFirstName() {
        if (leadBowler == null) {
            System.out.printf("*** ERROR: BowlingSystem: No Lead Bowler!\n");
            return "";
        }
        return leadBowler.getString("first");
    }



    /*
        Manager Functionality
     */

    @Override
    public void addCustomer(String first, String last, String email) {
        Bowler b = new Bowler();
        b.setString("first", first);
        b.setString("last", last);
        b.setString("email", email);
        b.saveRecord();

        boolean cardPrinted;
         do {
             cardPrinted = PrintingService.printCard(first, last, b.getString("id"));
         } while (! cardPrinted);
    }
}
