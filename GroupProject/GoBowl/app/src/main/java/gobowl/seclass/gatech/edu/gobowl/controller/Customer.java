package gobowl.seclass.gatech.edu.gobowl.controller;

/**
 * Created by charles on 7/6/16.
 */
public interface Customer {
    //  When a customer first presents themselves, scan their card...
    public String login();

    //  Get the customer's name for greeting purposes
    public String getFirstName();

    //  Bowling Party Management...
    // true == ready to get a lane, false == more bowlers to scan
    public boolean requestLane(int numberOfBowlers);
    //  Scan the card of the next bowler in the party
    // -1 == Scan Error, 0 == need more bowlers, 1 == ready to get a lane
    public int nextBowler();
    //  Finish up the bowling party, release intermediate resources
    //  Returns the lane to use...
    public int startBowling();
}
