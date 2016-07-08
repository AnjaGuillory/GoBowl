package edu.gatech.seclass.gobowl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.gatech.seclass.services.CreditCardService;
import edu.gatech.seclass.services.PaymentService;
import edu.gatech.seclass.services.PrintingService;
import edu.gatech.seclass.services.QRCodeService;
import edu.gatech.seclass.gobowl.models.Bowler;
import edu.gatech.seclass.gobowl.models.BowlingParty;
import edu.gatech.seclass.gobowl.models.Lane;

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
    BowlingParty activeBowlingParty;


    @Override
    public boolean requestLane(int numberOfBowlers) {
        totalBowlers = numberOfBowlers;
        bowlersSoFar = 1;
        activeBowlingParty = new BowlingParty();
        activeBowlingParty.addBowler(leadBowler);
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

        Bowler b = new Bowler(id);
        activeBowlingParty.addBowler(b);

        bowlersSoFar++;

        if (bowlersSoFar == totalBowlers) {
            return 1;
        }

        return 0;


    }

    @Override
    public int startBowling() {
        int lane = Lane.getFreeLane();
        activeBowlingParty.setInteger("lane", lane);
        activeBowlingParty.setInteger("active", 1);
        activeBowlingParty.saveRecord();
        return lane;


    }

    private double fee = 0;
    @Override
    public boolean checkOut() {
        activeBowlingParty = BowlingParty.getByBowler(leadBowler);
        if (activeBowlingParty == null ) {
            return false;
        }

        fee = 15.99;            // Stub for real calculation


        return true;
    }

    @Override
    public double getFees() {
        return fee;
    }

    @Override
    public int getLane() {
        return activeBowlingParty.getInteger("lane");
    }

    private int numCreditCards;
    private double individualfee;

    @Override
    public void setNumCreditCards(int n) {
        numCreditCards = n;
        individualfee = ((int) (100 * fee / n))/100.0;
    }

    @Override
    public int makePayment() {
        String ccInfo = CreditCardService.readCreditCard();
        if (ccInfo.equals("ERR")) {
            return -1;
        }

        String[] fields = ccInfo.split("#");

        SimpleDateFormat pd = new SimpleDateFormat("MMddyyyy");

        Date expiry;

        try {
            expiry = pd.parse(fields[3]);
        } catch (ParseException e) {
            System.out.printf("Error parsing credit card expiration: %s\n", e.toString());
            expiry = new Date();
        }
        if (PaymentService.processPayment(fields[0], fields[1], fields[2], expiry, fields[4], individualfee)) {
            numCreditCards--;
            if (numCreditCards == 0) {
                activeBowlingParty.setString("active", "0");
                activeBowlingParty.saveRecord();
                return 1;
            }
            return 0;
        }

        return -2;
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

    private Bowler customer;

    @Override
    public boolean findCustomer(String last, String email) {
        if (last != null && last.length() > 0) {
            customer = Bowler.findByName(last);
            if (customer != null) {
                return true;
            }
        }

        if (email != null && email.length() > 0) {
            customer = Bowler.findByEmail(email);
            if (customer != null) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean reprintCard() {
        // Just loop until printed, darn it!
        while (true) {
            if (PrintingService.printCard(customer.getString("first"), customer.getString("last"), customer.getString("id"))) {
                return true;
            }
        }
    }

    @Override
    public String getCustomerFirst() {
        return customer.getString("first");
    }

    @Override
    public String getCustomerLast() {
        return  customer.getString("last");
    }

    @Override
    public String getCustomerEmail() {
        return customer.getString("email");
    }

    @Override
    public void updateCustomer(String first, String last, String email) {
        customer.setString("first", first);
        customer.setString("last", last);
        customer.setString("email", email);
        customer.saveRecord();
    }
}
