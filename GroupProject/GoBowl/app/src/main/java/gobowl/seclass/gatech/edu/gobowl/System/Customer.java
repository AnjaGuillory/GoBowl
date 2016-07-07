package gobowl.seclass.gatech.edu.gobowl.System;

/**
 * Created by charles on 7/6/16.
 */
public interface Customer {
    public String login();
    public String getFirstName();
    public boolean requestLane(int numberOfBowlers);    // true == ready to get a lane
    public int nextBowler();                            // -1 == Scan Error, 0 == need more bowlers, 1 == ready to get a lane
}
