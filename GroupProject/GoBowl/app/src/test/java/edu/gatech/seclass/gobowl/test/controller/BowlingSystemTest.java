package edu.gatech.seclass.gobowl.test.controller;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.gatech.seclass.gobowl.controller.BowlingSystem;

/**
 * Created by arthurw on 7/8/2016.
 */
public class BowlingSystemTest {

    BowlingSystem bowlingSystem;

    @Before
    public void setUp() throws Exception {
        bowlingSystem = bowlingSystem.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        bowlingSystem = null;
    }

    @Test
    public void testLogin1() {
        String result;
        result = bowlingSystem.login();
        // login method returns empty string if not found otherwise return first name of lead bowler
        assertTrue(result == "" || result == "Ralph" || result == "Betty" || result == "Everett");
    }
}
