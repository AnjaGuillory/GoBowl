package edu.gatech.seclass.gobowl;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import gobowl.seclass.gatech.edu.gobowl.R;
import edu.gatech.seclass.gobowl.controller.BowlingSystem;
import edu.gatech.seclass.gobowl.util.CheesyCallback;
import edu.gatech.seclass.gobowl.util.CheesyDialog;

public class CustomerNumBowlers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_num_bowlers);
    }


    public void buttonGetOthers(View view) {
        int numBowlers;
        Intent myIntent;
        EditText etNum = (EditText) findViewById(R.id.etNumBowlers);

        try {
            numBowlers = Integer.parseInt(etNum.getText().toString());
        } catch (Exception e) {
            CheesyDialog cd = new CheesyDialog(this);
            cd.dialog("Error", "Please enter a valid number", null);
            return;
        }

        if (BowlingSystem.getInstance().requestLane(numBowlers)) {
            myIntent = new Intent(this, CustomerLaneDisplay.class);
            startActivity(myIntent);
            return;
        }

        myIntent = new Intent(this, CustomerLogin.class);
        myIntent.putExtra("title","Scan Next Bowler Please");
        myIntent.putExtra("action", "next");
        startActivityForResult(myIntent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent myIntent;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String why = data.getStringExtra("why");
            if (why != null && why.equals("next")) {
//                if (data.getIntExtra("status", 1) == 1) {         // THIS DOES NOT WORK FOR SOME UNKNOWN REASON!!
                if (Integer.parseInt(data.getStringExtra("status")) == 1) {
                    myIntent = new Intent(this, CustomerLaneDisplay.class);
                    startActivity(myIntent);
                    return;
                }

                CheesyDialog cd = new CheesyDialog(this);
                cd.dialog("Bowling Party", "Customer Scanned!",
                        new CheesyCallback() {
                            @Override
                            public void allDone(android.content.Context parent) {
                                Intent myIntent = new Intent(parent, CustomerLogin.class);
                                myIntent.putExtra("title","Scan Next Bowler Please");
                                myIntent.putExtra("action", "next");
                                startActivityForResult(myIntent, 0);

                            }
                        }
                );

            }
        }
    }

}
