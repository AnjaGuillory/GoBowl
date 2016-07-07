package gobowl.seclass.gatech.edu.gobowl.System;

import java.util.ArrayList;
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



    /*  ***********************************************************************

        Customer Functions....

        *********************************************************************** */


    /*  Login: Hit the scanner, look up the customer.
        Returns first name if found, or "" if not.                              */

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

    /*  get the first name of the lead bowler (for greeting purpooses)          */
    @Override
    public String getFirstName() {
        if (leadBowler == null) {
            System.out.printf("*** ERROR: BowlingSystem: No Lead Bowler!\n");
            return "";
        }
        return leadBowler.getString("first");
    }

    private int totalBowlers;
    private int bowlersSoFar;
    private ArrayList<Bowler> party;


    @Override
    public boolean requestLane(int numberOfBowlers) {
        totalBowlers = numberOfBowlers;
        bowlersSoFar = 1;
        party = new ArrayList<>();
        party.add(leadBowler);
        if (totalBowlers == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int nextBowler() {
        String id;
        id = QRCodeService.scanQRCode();

        if (id.equals("ERR")) {
            return -1;
        }

        party.add(new Bowler(id));
        bowlersSoFar++;

        if (bowlersSoFar == totalBowlers) {
            return 1;
        }

        return 0;


    }

    /*  ***********************************************************************

        Manager Functions....

        *********************************************************************** */

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
