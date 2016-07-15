package edu.gatech.seclass.gobowl.test.controller;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import edu.gatech.seclass.gobowl.controller.BowlingSystem;
import edu.gatech.seclass.gobowl.models.Persistence;


/**
 * Created by arthurw on 7/8/2016.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class BowlingSystemTest extends InstrumentationTestCase {

    private Context instrumentationContext;
    BowlingSystem bowlingSystem;

    @Before
    public void setUp() throws Exception {
        bowlingSystem = bowlingSystem.getInstance();
        instrumentationContext = InstrumentationRegistry.getContext();

        File bowlfile = instrumentationContext.getDatabasePath("bowler");
        Persistence.getInstance().initDB(bowlfile);

    }

    @After
    public void tearDown() throws Exception {
        bowlingSystem = null;
    }

    @Test
    public void testLogin1() {
        System.err.println("logging in");
        String result;
        //Assert.fail();
        result = bowlingSystem.login();

        // login method returns empty string if not found otherwise return first name of lead bowler
        assertTrue(result == "" || result == "Ralph" || result == "Betty" || result == "Everett");
    }
}
